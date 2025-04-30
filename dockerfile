# Stage 1: Build stage
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
 
# Stage 2: Runtime stage
FROM tomcat:9.0-jdk11-openjdk-slim AS runtime
WORKDIR /usr/local/tomcat/webapps
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/onlinebookstore.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
