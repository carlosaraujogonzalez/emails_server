# emails_server
Emulation of an email server. This server is made up three microservices (micro db, emailserver, scheduler)

Execute these steps to run this Microservice
1. mvn clean package -DskipTests
2. Make sure you have RabbitMQ server running on localhost:15672
3. Create a new run configuration -> maven + spring-boot:run
4. Run the application
