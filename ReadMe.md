# **ReadMe** 


## - **Pay My Buddy Application** 

An app to transfer money easyly . </br>
This app uses Java to run.


## - **Getting Started**

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 


## - **Prerequisites**

You need to install : 
* Java 17
* Maven 3.8.7
* MySQL 8.0.31


## - **Installing** 

* [Install Java](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Install Maven](https://maven.apache.org/install.html)
* [Install MySQL](https://dev.mysql.com/downloads/mysql/)

After downloading the mysql 8 installer and installing it, you will be asked to configure the password for the default root account. 
--------------------- This code uses the default root account to connect and the password can be set as rootroot. 
If you add another user/credentials make sure to change the same in the code base.


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


## - **Running App** 

Post installation of MySQL, Java and Maven, you will have to set up the tables and data in the data base. 
For this, please run the sql commands present in the *DatabaseCreation.sql* and *Data.sql* files under the *resources* folder in the code base.

Import the code into an IDE of your choice.

mdp bdd...

Run the *PayMyBuddyApplication.java* class to launch the application.


## - **Documentation**

You can access the app in a webbrowser at this address : http://localhost:8080/index. </br>


## - **UML Class Diagram**

![UMLClassDiagram.png](UMLClassDiagram.png)


## - **Physical Data Model**

![PhysicalDataModel.png](PhysicalDataModel.png)


## - **Testing**

The app has unit tests and integration tests written. </br>
To run the tests from maven, go to the folder that contains the pom.xml file and execute the following command : *mvn test*. </br>
To get both Surefire Report and Jacoco Report in Maven Site, you can execute the command mvn site and open the file « *index.html* » in the folder ./target/site. </br>
JaCoCo and Surefire reports are in the section « *Project Reports* ».
