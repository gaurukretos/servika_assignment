# servika_assignment
This project provides a set of RESTful APIs to manage products. It allows users to perform CRUD operations on products using endpoints documented through Swagger UI.

#USING GIT COMMAND FOR CREATE NEW REPOSITIRY

#Setting up the Remote Origin 
git remote add origin https://github.com/gaurukretos/servika_assignment/tree/master
#For Checking the Current Remote 
git remote -v 
#Add the files to the GIT 
git add . 
#Commenting the messages on git 
git commit -m "assignments"
#Pushing the code on the Remote 
git push origin master --force


#PREREQUISITES
Prerequisites
Java 17
Maven
PostgreSQL
IDE:VsCode

#DATABASE CONFIGURATION
spring.datasource.url=jdbc:postgresql://localhost:5432/sarvika_assignment_db
spring.datasource.username=postgres
spring.datasource.password=1234
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

#ACCESSING SWAGGER UI
http://localhost:8080/swagger-ui/index.html

#API ENDPOINTS
1.Get all products:- /products/{id}
2.Create a new product:- /products
3.Update an existing product:- /products/{id}
4.Delete a product:- /products/{id}

#CREATE PRODUCT JSON:-
{
  "name": "Product Name",
  "description": "Product Description",
  "price": 100.0
}

#UPDATE PRODUCT JSON:-
{
  "id":"",
  "name": "Product Name",
  "description": "Product Description",
  "price": 100.0
}



