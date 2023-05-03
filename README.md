# Hi, I'm Raluca! 👋

Here you can find the documentation of the Hotel Reservation System

## 🚀 About Me
💻Back-end software developer | 👨‍💻Helping companies to build great back-ends | Java, Spring Boot | Passionate about solving problems using technology


## 🛠 Skills
Back-end development · Unit Testing · Java · Algorithms · OOP · Relational Databases · SQL · Git · HTML · CSS · Web services · REST APIs · Spring Boot · Spring Framework · MySQL · Data Structures · Web Development · Software Development


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://kimkalura.github.io/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/floriana-raluca-deftu/)

# Hotel Reservation System

This application was developed to book a hotel room (or more) by a customer. The standard procedure for responding to a guest's request for this application is to receive reservation requests and determine room availability.

## Features
As a client, I can:
-	add a reservation
-	view available rooms
-	view number of available rooms


As an admin, I can:
-	add a hotel
-	add a room
-	delete room
-	find all rooms by hotel
-	update room price
-	view price for all reservations between dates
-	view available rooms ordered by price (for a certain period of time and number of people)

## Built with

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

## API Reference

#### Add a reservation

```http
  POST /reservation/add
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of the reservation to be added  |

Request body example:

```json
{
 "roomIds" : [0],
 "checkIn" : "2022-12-24T08:00:00",
 "checkOut" : "2023-01-05T12:00:00"
}
```  
Postman example:

![App Screenshot](https://i.imgur.com/EbEsj7X.png)

MySQL example:

![App Screenshot](https://i.imgur.com/BNT3Pe5.png)


#### View available rooms

```http
  GET /reservation/availability
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of the reservation to fetch  |
Request body example:

```json
{
    "startDate": "2023-05-05T10:00:00",
    "endDate": "2023-05-10T10:00:00",
    "numberOfPersons": "0"
}
```


#### View number of available rooms

```http
  GET reservation/numberOfAvailableRooms
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of the reservation to fetch  |

Request body example:

```json
{
    "startDate": "2023-01-24T10:00:00",
    "endDate": "2023-02-06T10:00:00",
    "idHotel": "0"
}
```  


#### View price for all reservations between dates

```http
  GET reservation/priceForAllReservations
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of the reservation to fetch  |

Postman example:

![App Screenshot](https://i.imgur.com/TnXwxIu.png)



####  View available rooms ordered by price (for a certain period of time and number of people)

```http
  GET reservation/priceForAllReservations
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of the reservation to fetch  |

Request body example:

```json
{
    "startDate": "2023-05-05T10:00:00",
    "endDate": "2023-05-10T10:00:00",
    "numberOfPersons": "0"
}
```  
Postman example:

![App Screenshot](https://i.imgur.com/lGB7ege.png)


#### Add a hotel

```http
  POST /hotel/add
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of the hotel to be added  |

Request body example:

```json
{
    "name":"string"
}
``` 

#### Add a room

```http
  POST /room/add/${hotelId}
```

| Parameter | Type     | Description                                        |
|:----------|:---------|:---------------------------------------------------|
| `id`      | `string` | **Required**. Id of a hotel to be fetch            |
| `body`    | `json`   | **Required**. The properties of a room to be added |

Request body example:

```json
{
  "roomNo": "0",
  "price" : "0",
  "noOfPerson" : "0"
}
```  
Postman example:

![App Screenshot](https://i.imgur.com/NmJGSGQ.png)


#### Delete room

```http
  DELETE /room/delete/${roomId}
```

| Parameter | Type     | Description                            |
| :-------- | :------- |:---------------------------------------|
| `id` | `string` | **Required**. Id of the room to delete |


#### Find all rooms by hotel

```http
  GET /room/findAllRooms/{hotelId}
```

| Parameter | Type     | Description                |
| :-------- |:---------| :------------------------- |
| `id` | `string` | **Required**. Id of the hotel to fetch  |


#### Update room price

```http
  PUT /room/update/${roomId}/${newPrice}
```

| Parameter | Type     | Description                                            |
| :-------- | :------- |:-------------------------------------------------------|
| `id` | `string` | **Required**. Id of the room and a new price to update |
| `new price` | `json` | **Required**. New price of the room to be updated |

Postman example:

![App Screenshot](https://i.imgur.com/V13FWlM.png)



## API Authentication and Authorization

There are only two requests which don't require authorization headers.

#### Authenticate (login)

```http
  POST /authenticate
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of user to authenticate  |

Request body example:

```json
{
  "password": "string",
  "username": "string"
}
```  

#### Register

```http
  POST /authenticate
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of user to register  |

Request body example:

```json
{
  "email": "string",
  "password": "string",
  "username": "string"
}
```  
After running the authenticate request, the client will obtain an access token that will be used in all subsequent request in order to authenticate the user and to authorize the user based on its role.

This is an example of what should be included in the request header:

```http
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjcxMTQzMzEyfQ.dxIzsD9Bm8y_kw3MOoZ2JXIKOg--uZaA5XNtBLdGYc4Ps3nlzBFDwBJi0bEeHlCggonZ6nQ2zwCI0D5a7dXjmw
```  
## Prerequisites

For building and running the application you need:
- JDK 1.8 or higher
- Maven 3

For deploying on Heroku you need:
- GIT
- Heroku CLI
## Dependencies

You don't need any additional dependencies.
All dependecies related to database management, server management, security management and so on, will be automatically injected by Maven using the pom.xml file located in the root folder of the project.

## Installation

Clone the project

```bash
  git clone https://github.com/KimKalura/Hotel-Reservation-System
```

Go to the project directory

```bash
  cd my-project
```

## Run Locally

Use maven to build the app and, to run it, and to start the local embedded Tomcat server

```bash
  mvn spring-boot:run
```


## Running Tests

To run tests, run the following command

```bash
  mvn test
```


## Environment Variables

You can deploy this project using Heroku or other providers as well, by specifying the following environment variables:

`PROFILE`

`MYSQL_URL`

`MYSQL_USER`

`MYSQL_PASS`



## Deployment

To deploy this project run

```bash
  git push heroku master
```


## Usage

You cand use demo version of the app, using SwaggerUI and following this link:

```bash
https://vast-peak-02725.herokuapp.com/swagger-ui/
```

First, obtain an access token by running the /authenticate endpoint with username "user" and password "pass", which will grant you admin rights in the application.

![App Screenshot](https://i.imgur.com/GX34Sdn.png)

After that, authorize yourself by clicking the authorize button and copy-pasteing the token from the response.

![App Screenshot](https://i.imgur.com/arTX2Ke_d.webp?maxwidth=760&fidelity=grand)

From now on, you can use all other available endpoints, as per swagger documentation.

## Badges

![Maintained](https://img.shields.io/badge/Maintained%3F-yes-green.svg)
![GIT](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![JWT](https://img.shields.io/badge/json%20web%20tokens-323330?style=for-the-badge&logo=json-web-tokens&logoColor=pink)