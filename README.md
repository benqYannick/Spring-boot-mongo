# Architecture Diagram
Spring Boot, MongoDB, AWS EC2
![Sorry I'm badman!](https://benqyannick.github.io/Spring-boot-mongo/static/img/architecture-diagram-II.png)

# Postman Settings
1. Postman import API file [Spring-boot-Production.postman_collection.json](https://github.com/benqYannick/Spring-boot-mongo/tree/master/static/postman-example)

2. After importing the file, the following image will be displayed: "Spring-boot-Local" folder
![Sorry I'm badman!](https://benqyannick.github.io/Spring-boot-mongo/static/img/postman-get-all.png)

* Get all: Show all MemoryUsage data
* Get one: Display a specified amount of MemoryUsage data
* Post one: Add a new MemoryUsage data
* Put one: Update a MemoryUsage data
* Del one: Delete a MemoryUsage


# MongoDB setting
- Create User
```
db.createUser(
    {
        user : "[your user name]",
        pwd : "[your password]",
        roles: [ 
            {
                role : "readWrite", db : "admin"},
            {
                role:  "userAdminAnyDatabase",
                db : "admin"
            }
        ]
    }
)
```

- MongoDB login
```
use admin
db.auth("[your user name]","[your password]")
```

- Create collection
```
db.createCollection("memoryUsage");
```

- Insert data to collection
```
db.memoryUsage.insertMany([
  {
    "memoryUsage" : "6.1G"
  },
  {
    "memoryUsage" : "5.1G"
  },
  {
    "memoryUsage" : "7.1G"
  }
]);
```
![Sorry I'm badman!](https://benqyannick.github.io/Spring-boot-mongo/static/img/mongodb-compass.png)


# Ubuntu Systemd setting
Added spring-boot.service file
`vi /etc/systemd/system/spring-boot.service`
![Sorry I'm badman!](https://benqyannick.github.io/Spring-boot-mongo/static/img/systemd.png)

```
[Unit]
Description=spring-boot

[Service]
ExecStart=/usr/bin/java -jar /var/www/Spring-boot-mongo/target/demo-0.0.1-SNAPSHOT.jar
StandardOutput=file:/var/log/spring-boot.out.txt
StandardError=file:/var/log/spring-boot.err.txt
Type=simple
WorkingDirectory=/var/www/Spring-boot-mongo/target

[Install]
WantedBy=multi-user.target
```
(1) click esc (2) input :wq  


# Systemd start Setting
- Reload  
`sudo systemctl daemon-reload`

- Start  
`sudo systemctl start spring-boot`  

- Status  
`sudo systemctl status spring-boot`  

- Stop  
`sudo systemctl stop spring-boot`  

- Enable service startup on boot   
`sudo systemctl enable spring-boot`  

- Disable service startup on boot  
`sudo systemctl disable spring-boot`  


# Spring-boot setting the MongoDB connection info
In the `src/main/resources/application.properties` file. Add the following lines to the file 
```
spring.data.mongodb.host=[host]
spring.data.mongodb.port=[port]
spring.data.mongodb.authentication-database=[authentication_database]
spring.data.mongodb.username=[username]
spring.data.mongodb.password=[password]
spring.data.mongodb.database=rest_tutorial
```

# Command line run Spring-boot
- Method 1：Use to terminal run
`mvn spring-boot:run`

- Method 2：Run after made to the Jar
```
mvn package
cd target/
java -jar spring-boot-demo-0.0.1-SNAPSHOT.jar
```
![Sorry I'm badman!](https://benqyannick.github.io/Spring-boot-mongo/static/img/spring-run.png)


