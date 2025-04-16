
terraform {
  backend "s3" {
    bucket = "terraform-jenkinsstatefilestore"
    key =   "env/terraform.tfstate"
    region = "us-west-2"
  }
}

resource "aws_instance" "demo" {
    ami = "ami-075686beab831bb7f"
    instance_type = "t2.micro"
    security_groups = [aws_security_group.tf_sg.name]
    tags = {
    Name = "HelloWorld1"
    }
  
}


resource "aws_security_group" "tf_sg" {
  name        = "tf_sg2324"
  description = "Allow TLS inbound traffic"
  vpc_id      = "vpc-0935e460384f05540"

  ingress {
    description = "TLS from VPC"
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
   
  }
  ingress {
    description = "TLS from VPC"
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
   
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "allow_tls"
  }
}