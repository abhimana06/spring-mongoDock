# spring-mongoDock

Containrized Spring boot application which performs basic CRUD operations with MongoDB container as DB using Docker.

Connected to 'mongo' container for Mongo database connection.

Command to create Mongo DB container

--> docker pull mongo

--> docker run -d -p 27017:27017 --name mymongodb mongo

Command to build and run the spring-mongo container

--> docker build -f Dockerfile -t spring-mongo .

--> docker run -t --name spring-mongo --link mymongodb:mongo -p 9000:9000 spring-mongo
