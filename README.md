# Spring Boot Profile Application

This is a Spring Boot profile application that demonstrates how to manage different application configurations based on profiles.

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

## Profiles

This application supports multiple profiles, each with its own configuration. You can set the active profile using the --spring.profiles.active property when running the application.

- `dev`: Development profile with development-specific configuration.
- `prod`: Production profile with production-specific configuration.

