# Bookstore Web Application

## Overview
This project is a full-stack web application for a bookstore. It uses Spring Boot for the backend, Angular for the frontend, PostgreSQL as the database, and is deployed on AWS.


This is  is the code base of my backend which is part of my BookStore project which also contains the web app with angular and spring boot and android version
**android**: **https://github.com/mounirrouissi/BookApp**
**angular** : **https://github.com/mounirrouissi/bookstoreFront**

## Prerequisites
- JDK 1.8 or later
- Maven 3.2+
- Node.js 10+
- Angular CLI
- PostgreSQL
- AWS Account

## Backend - Spring Boot
### Setting up
- Clone the repository: `git clone [repository-url]`
- Navigate to the server directory: `cd server`
- Build the project: `mvn clean install`
- Run the application: `mvn spring-boot:run`

### Configuration
- `application.properties` contains the database and server configuration.

## Frontend - Angular
### Setting up
- Navigate to the client directory: `cd client`
- Install dependencies: `npm install`
- Run the application: `ng serve --open`

### Building for production
- Generate a production build: `ng build --prod`

## Database - PostgreSQL
- Ensure PostgreSQL is installed and running.
- Create the database schema using the provided SQL scripts.

## Deployment - AWS
- The application is configured for deployment on AWS Elastic Beanstalk.
- Static assets are hosted on AWS S3.
- The database is hosted on AWS RDS.

## Continuous Integration
- This project uses GitHub Actions for CI/CD.
- `.github/workflows` directory contains the workflow configuration.

## Contributing
Please read [CONTRIBUTING.md](https://github.com/bezkoder/spring-boot-angular-16-postgresql-example/blob/master/README.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License
This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/bezkoder/spring-boot-angular-16-postgresql-example/blob/master/README.md) file for details.

## Acknowledgments
- Hat tip to anyone whose code was used
- Inspiration
- etc

