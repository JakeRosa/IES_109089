# **Lab1 Notes**

## **Maven: Basic Commands**

**mvn --version**: This command displays the version of Maven installed on your system. It's useful for verifying if Maven has been successfully installed.

**mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false**: This is an interactive command that allows you to create a new Maven project.

**mvn package**: This command creates a package (typically a JAR file) of your compiled project. The resulting package is usually placed in the "target" folder of your project.

**mvn exec:java -Dexec.mainClass=groupId.Main**: Maven compiles the project and executes the Main class.

**mvn exec:java -Dexec.mainClass=groupId.Main -Dexec.args="arg1 arg2 arg3"**: Similar to the previous command but allows you to pass multiple arguments to the Java class being executed.

**mvn install**: Use this command to install the artifact (usually a JAR file) into the local Maven repository. This enables other local projects to use this artifact as a dependency.

**mvn clean**: To clean the target directory and remove all files generated during the project build.

**mvn clean install**: Sometimes, it's useful to execute both the "clean" and "install" commands together to clean the project and install it in the local repository.

## **Maven: POM File (MyWeatherRadar)**
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.jake.app</groupId>
  <artifactId>MyWeatherRadar</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>MyWeatherRadar</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>com.squareup.retrofit2</groupId>
      <artifactId>retrofit</artifactId>
      <version>2.9.0</version>
    </dependency>
    <dependency>
      <groupId>com.squareup.retrofit2</groupId>
      <artifactId>converter-gson</artifactId>
      <version>2.9.0</version>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-api</artifactId>
      <version>2.20.0</version>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.20.0</version>
    </dependency>
  </dependencies>
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>
</project>

```

## **Log4j2**
### Add this to the pom.xml file:
```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.20.0</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.20.0</version>
</dependency>
```
### Create a log4j2.xml in the ‘src/main/resources‘ folder
## **Logging to Console**
#### log4j2.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- Extra logging related to initialization of Log4j.
 Set to debug or trace if log4j initialization is failing. -->
<Configuration status="warn">
    <Appenders>
    	<!-- Console appender configuration -->
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout
                pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n" />
        </Console>
    </Appenders>
    <Loggers>
    	<!-- Root logger referring to console appender -->
        <Root level="info" additivity="false">
            <AppenderRef ref="console" />
        </Root>
    </Loggers>
</Configuration>
```
## **Logging to File**
#### log4j2.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="warn">
	<Appenders>
		<RollingFile name="fileLogger"
			fileName="app.log"
			filePattern="app-%d{yyyy-MM-dd}.log">
			<PatternLayout>
				<pattern>[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
				</pattern>
			</PatternLayout>
			<Policies>
				<TimeBasedTriggeringPolicy interval="1" modulate="true" />
				<SizeBasedTriggeringPolicy size="10MB" />
			</Policies>
		</RollingFile>
	</Appenders>
	<Loggers>
		<Root level="info" additivity="false">
			<appender-ref ref="fileLogger" />
		</Root>
	</Loggers>
</Configuration>
```
## **Applying to Main**
```java
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	public static void main(final String... args)
	{
		logger.debug("Debug Message Logged !!!");
		logger.info("Info Message Logged !!!");
		logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
	}
}
```


## **Docker: Basic Commands**

**docker --version**: This command displays the version of Docker installed on the system.

**docker pull <image_name>**: This command downloads a Docker image from Docker Hub or another image registry.

**docker run <image_name>**: This command creates and starts a Docker container based on the specified image.

**docker ps**: To list the running containers on the system.

**docker ps -a**: To list all containers, including the ones that are stopped.

**docker stop <container_id>**: This command stops a running container.

**docker rm <container_id>**: To remove a stopped container.

**docker images**: This command lists all available Docker images on the system.

**docker rmi <image_name>**: To remove a Docker image from the system.

**docker build -t <image_name> <path_to_Dockerfile>**: This command builds a custom Docker image based on a Dockerfile.

**docker-compose up**: If you are using Docker Compose, this command starts all services defined in your `docker-compose.yml` file.

**docker-compose down**: To stop and remove all services defined in your `docker-compose.yml` file.