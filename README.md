# Spring Boot Profile Application

This is a Spring Boot profile application that demonstrates how to manage profile section of an application.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (openjdk_17.0.8)
- Your favorite Integrated Development Environment (IDE)

## Getting Started

1. Clone this repository to your local machine:

   ```shell
   git clone https://github.com/SerifeCanevi/profile
   ```

2. Navigate to the project directory:

   ```shell
   cd profile
   ```

3. Build the application using Maven:

   ```shell
   mvn clean install
   ```

4. Run the application with a specific profile (e.g., dev or prod):

   ```shell
   java -jar target/profile.jar --spring.profiles.active=dev
   ```

## Database Schema
<p align="center" width="100%">
  <img src="https://github.com/SerifeCanevi/profile/blob/9648fd6d255ec0470e4dad95eeab26668d696348/src/main/resources/db/drawSQL-profile-micro.png" 
    width="72%" />
</p>
