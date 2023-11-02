FROM maven:3.8.5-openjdk-17
WORKDIR /lab3_3
COPY . .

RUN mvn install -DskipTests

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]