# Mentorship Platform

A full-featured mentorship web application built using Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript.

## Features

- User registration and login (Mentor & Mentee)
- Dashboard for both mentors and mentees
- Appointment booking system
- Real-time messaging/chat feature
- Profile management for mentors
- Admin or server-side session control

## Technologies Used

- Java (Servlets, JSP)
- JDBC & MySQL
- HTML, CSS, JavaScript
- Bootstrap (optional)
- Apache Tomcat (local server)
- Eclipse IDE

  ## Project Structure

MentorshipPlatform/ │ ├── src/ │  
├── com.hrit.mentorship_platform.model/ │  
├── com.hrit.mentorship_platform.dao/ │   
├── com.hrit.mentorship_platform.servlet/ │ 
├── WebContent/ │   
├── css/ │   
├── js/ │   
├── jsp/ │   
├── index.jsp │ 
└── login.jsp, 
register.jsp, 
dashboard.jsp,
chat.jsp, etc. │
├── lib/ (JDBC drivers) ├── .gitignore ├── README.md
└── pom.xml or project setup files
## How to Run Locally

1. Clone this repository:

git clone https://github.com/Sonityagi06/mentorship-platform.git

2. Import into Eclipse as a Maven Project.

3. Configure Apache Tomcat server and set up the MySQL database using provided schema.

4. Run the application and visit:

http://localhost:8080/MentorshipPlatform/

## Database

Create a MySQL database named mentorship_platform and import the tables:
- user_login
- mentor
- mentee
- appointments
- messages

## License

This project is for educational purposes.
