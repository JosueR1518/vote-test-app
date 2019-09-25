# Vote App  - Spring Boot Project

*Application to manage an online voting site where users can register their personal data and allow
them to vote for candidates that belong to a specific committee.*


**Prerequisites:** 
   
 1. JDK 1.8 or later 
 2. Maven 3 or later 
 3. Database is made in MySQL

 

> This tutorial is for people with experience working with  Spring Boot Apps, Maven, Eclipse or Netbeans IDE.

**How to run on eclipse?**
## 1. Prepare the project
 - [ ] Clone or download ZIP
 - [ ] Import project into Eclipse
 - [ ] Install dependencies with Maven (From terminal: mvn install)
		 
	 1. Rigth click over project -> Maven -> Update Project...
	 2. Run the project: rigth click over project -> Run As -> Spring Boot App

 - [ ]  Run the script of the database from file database_vote_test.sql,   It's in main folder, the name database: vote_test
## 2. Config database conexion
 - [ ] Go to path: src/main/resources and configure file **"application.properties"**
 - [ ] You have to set  "user and password" 
 - [ ]  Change parameters base of your own details (replace "[values]") 
		      **spring.datasource.url = [URI database ]
				spring.datasource.username = [username]
				spring.datasource.password = [password]**

  
# 3.  Test App

> You may access to location server and port at: [http://localhost:8080/](http://localhost:8080/) 
 1. Sign up (It's very simple)
		*I recommend that you choose a country between El Salvador, Guatemala or Costa Rica.*
 2. Once you Sign in, you can vote for candidates that belong to a specific committee registered for your country.
 

## How to consume Web Services?

> I have implemented "Content Negociation" which means that you can get the response in JSON or XML format. (You have to send a header param - {"Accept": "application/xml"})

*If you prefer, you can use "Postman App"

1. **Get candidates registered**
	Type on your browser : [http://localhost:8080/getRegisteredCandidates](http://localhost:8080/getRegisteredCandidates)

2. **Get number of visitors per date**
	Type on your browser : [http://localhost:8080/getVisitorsReport](http://localhost:8080/getVisitorsReport)

## Integration need

A report with committee statistics in JSON format order by committee name is send by email to the administrators once a day (at 10 AM CST).


The implementation is located in path:  src/main/java/com/telus/testtelus/component/ScheduledTasks.java



## Any doub?

You can get it touch with me.  [https://www.jossuemejia.com](https://www.jossuemejia.com)


# 4.  Some screenshots

![Login](https://picasaweb.google.com/112572088688238602899/6740525782926113985#6740525781005607090 "login")


![SignUp](https://picasaweb.google.com/112572088688238602899/6740525970083564945#6740525974112779746 "SignUp")


![List of committees](https://picasaweb.google.com/112572088688238602899/6740526124876801169#6740526129755969458 "List of committees")


![Vote for a candidate](https://picasaweb.google.com/112572088688238602899/6740526274130441665#6740526271768671842 "Vote for a candidate")

