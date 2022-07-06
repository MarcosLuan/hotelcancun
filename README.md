# Hotel Cancun Project

Post-Covid scenario:
People are now free to travel everywhere but because of the pandemic, a lot of hotels went
bankrupt. Some former famous travel places are left with only one hotel.
You’ve been given the responsibility to develop a booking API for the very last hotel in Cancun.

## 🚀 Starting

These instructions will allow you to get a working copy of the project on your local machine for development and testing purposes.

### 📋 Requirements

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copi10ed into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```
The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

###For more information access
[Related guide section...](https://quarkus.io/guides)

###Database
Create a local database named hotelcancun. The tables will be created automatically

### 🔧 Configurations

To run this project on your machine, have the necessary java packages installed (JAVA 8 or plus),

After cloning the project, open it in your favorite development environment, start the project and wait for the dependencies to be installed.
All dependencies in pom.xml are necessary for correct operation.

## ⚙️ Tests

The tests are located in the directory: hotelcancun\src\test.
Tests can be run normally in your development environment as per your local settings.

## 🔩 Swagger

http://localhost:8082/docs/

## 🔩 Requisitions Postman

###Bookroom
GET all bookrooms
```
http://localhost:8082/bookroom
```

GET bookrooms by user document
```
http://localhost:8082/bookroom/byDocument/{user_document}
```

POST bookrooms save
```
http://localhost:8082/bookroom/save

{
	"userDocument":"String",
	"userName":"String",
	"phoneUser":"String",
	"entryDate":"2022-07-20",
	"departureDate":"2022-07-22"
}
```

PUT change bookroom
```
http://localhost:8082/bookroom/change
{
    "id":1
	"userDocument":"String",
	"userName":"String",
	"phoneUser":"String",
	"entryDate":"2022-07-20",
	"departureDate":"2022-07-22"
}
```

###Users
GET all users
```
http://localhost:8082/user
```

POST save new user
```
http://localhost:8082/user/save
{
    "document": "String",
    "name": "String",
    "phone": "String"
}
```

###Rooms
GET all rooms
```
http://localhost:8082/room
```

POST save new hotel room
```
http://localhost:8082/room/save
{
    "hotelName": "String",
    "numberRoom": 101
}
```
Note: Used only one room for the hotel

## 🛠️ built with

* [Java](https://docs.oracle.com/en/java/javase/11/docs/api/) - Programming Language
* [Quarkus](https://quarkus.io/guides) - Framework Java
* [Maven](https://maven.apache.org/) - Dependency Manager

## ✒️ Author

* **Marcos Luan Kades** - *Complete Project* - [github](https://github.com/MarcosLuan)

## 🎁 Thanks

* Thank you to everyone interested in the project 🤓.

---