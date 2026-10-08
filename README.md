# SMTP-Simple-mail-Transfer-Protocol-Mail-Sender-Project
Mail Sending Project 

# Mail Sender Project

## About Project

This is a Spring Boot project in which I created an OTP Email Sender system.

In this project, I am generating an OTP for the user and sending that OTP to the user's email address.

I used Gmail SMTP for sending the email and MySQL for storing the OTP details.

I created this project mainly to understand how email sending works in Spring Boot and how we can connect an email service with a database.

---

## Technologies I Used

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* JavaMailSender
* Gmail SMTP
* Maven
* Swagger
* Lombok

---

## How My Project Works

The flow of my project is:

```text
User
 ↓
Send Email
 ↓
OTP Controller
 ↓
OTP Service
 ↓
Generate OTP
 ↓
Save OTP in MySQL
 ↓
Email Service
 ↓
JavaMailSender
 ↓
Gmail SMTP
 ↓
OTP sent to User
```

---

## API

### Send OTP

I created an API for sending the OTP.

```text
POST /api/otp/send
```

Request:

```json
{
    "email": "example@gmail.com"
}
```

When I call this API, the application generates an OTP and sends it to the given email address.

---

## Email Sending

For sending emails, I used Spring Boot's `JavaMailSender`.

In my `EmailServiceImpl` class, I created the email message and used `JavaMailSender` to send it.

The basic flow is:

```text
EmailServiceImpl
      ↓
JavaMailSender
      ↓
Gmail SMTP
      ↓
User Email
```

I used Gmail SMTP configuration in my `application.properties`.

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

I am using environment variables for the Gmail username and App Password so that I don't expose my password in GitHub.

---

## Database

I used MySQL database for this project.

Database name:

```text
mailsender
```

The OTP information is stored in the database after generating the OTP.

This helps me to keep the OTP details and validate the OTP later.

---

## Main Classes

### OtpController

This class handles the API request.

```text
Client → OtpController
```

It receives the email address from the request and calls the OTP service.

### OtpServiceImpl

This class contains the main OTP logic.

It is responsible for:

* Generating OTP
* Saving OTP details
* Calling the email service

### EmailServiceImpl

This class contains the email sending logic.

It creates the email message and sends it using `JavaMailSender`.

### Repository

I used Spring Data JPA repository to communicate with the MySQL database.

---

## Swagger

I also added Swagger to test my APIs.

After starting the application, I can open:

```text
http://localhost:8080/swagger-ui/index.html
```

From Swagger, I can test my OTP API directly.

---

## How to Run the Project

First, create the database in MySQL:

```sql
CREATE DATABASE mailsender;
```

Then configure the database details in `application.properties`.

After that, configure the Gmail username and App Password.

Then run the Spring Boot application.

The application will run on:

```text
http://localhost:8080
```

---

## Important

I should not put my real Gmail password or App Password directly inside the project before uploading it to GitHub.

I am using:

```properties
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
```

instead of putting the actual credentials.

---

## What I Learned From This Project

While creating this project, I learned:

* How to create REST APIs using Spring Boot
* How to generate OTP
* How to store data using Spring Data JPA
* How to connect Spring Boot with MySQL
* How `JavaMailSender` works
* How Gmail SMTP works
* How to use Gmail App Password
* How to use environment variables
* How to test APIs using Swagger
* How to use Git and GitHub

---

## Future Improvements

In future, I can add:

* OTP verification API
* OTP expiry validation
* Resend OTP functionality
* Limit OTP attempts
* Better email template
* Global exception handling
* JWT authentication
* Docker deployment

---

## My Project

This project is created by me for learning and practicing **Java, Spring Boot, MySQL and Email Integration**.

