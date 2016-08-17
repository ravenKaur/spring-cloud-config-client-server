# spring-cloud-config-client-server
======================================
#Start config server without authentication
java -Dspring.cloud.config.server.git.uri=/Users/SamSingh/Documents/Meetu_Study/Git/spring-cloud-config-client-server-repo  -jar target/config-service-0.0.1-SNAPSHOT.jar
http://localhost:8888/foo.service/default

#Start services/client
#foo service
java -Dspring.cloud.config.server.git.uri=/Users/SamSingh/Documents/Meetu_Study/Git/spring-cloud-config-client-server-repo -Dserver.port=8081 -jar target/foo-service-0.0.1-SNAPSHOT.jar

#bar service
java -Dspring.cloud.config.server.git.uri=/Users/SamSingh/Documents/Meetu_Study/Git/spring-cloud-config-client-server-repo -Dserver.port=8082 -jar target/bar-service-0.0.1-SNAPSHOT.jar

#baz service
java -Dspring.cloud.config.server.git.uri=/Users/SamSingh/Documents/Meetu_Study/Git/spring-cloud-config-client-server-repo -Dserver.port=8083 -jar target/baz-service-0.0.1-SNAPSHOT.jar

# Refresh services
http://localhost:8081/refresh
http://localhost:8082/refresh
http://localhost:8083/refresh

# Check env

http://localhost:8081/env
http://localhost:8082/env
http://localhost:8083/env


====================================

#Start config server without authentication 
java -Dsecurity.user.name=config -Dsecurity.user.password=verysecure -Dspring.cloud.config.server.git.uri=/Users/SamSingh/Documents/Meetu_Study/Git/spring-cloud-config-client-server-repo  -jar target/config-service-0.0.1-SNAPSHOT.jar
http://config:verysecure@localhost:8888/foo.service/default

Add following dependency in main pom.xml

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>

======================================
# Encrypt/decrypt messages

java -Dsecurity.user.name=config -Dsecurity.user.password=verysecure  -Dspring.cloud.config.server.git.uri=/Users/SamSingh/Documents/Meetu_Study/Git/spring-cloud-config-client-server-repo  -Dencrypt.key=foobarbaz -jar target/config-service-0.0.1-SNAPSHOT.jar
# Add secret message with {cipher}
secret-message ={cipher} Message

=====================================
http://localhost:8888/monitor/*

=====================================
web hook through ngrok http 8888



