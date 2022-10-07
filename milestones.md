# Milestones
> This file lays out a general timeline that you can follow to gauge your progress on P1. 

> We can break our project down into smaller MVPs in order to make it more manageable. 

## By the beginning of Week 5
- Requirement Traceability Matrix and Test Case Document created
  - (Requirements and Test Cases with preconditions, steps, expected results, etc.)
- Database is set up (make sure you can view your Entity Relationship Diagram (ERD) and that it reflects the foreign key relationships between your tables)
- Application is connected to AWS RDS Database
  - (You are able to create a Connection Object using the ConnectionUtil class and DB credentials stored either in a `connection.properties` file or as System Environment Variables)
- Database persistence started (begin DAO implementation) - if this is complete then you're in good shape

## By the middle of Week 5
- Database persistence done (DAOs are implemented)
- Back end has Javalin Restful Endpoints (you can use Postman to make sure these work if you don't have a front end set up fully yet)
- Some Unit Tests written in JUnit (for Services Layer)
- Some BDD Scenarios / Cucumber Feature Files
- Some progress on front end (HTML and JavaScript)

## By the end of Week 5 
- Back end is complete with Javalin Restful Endpoints
- Front end mostly complete with asynchronous JavaScript for API calls
- Selenium Step Implementation for Cucumber Feature Files mostly complete

## By the beginning of Week 6
- Front end complete with styling
- BDD Testing (Selenium/Cucumber) complete
- RTM and Test Case Document Complete

## Due Wednesday of Week 6
- Application is functioning
- Presentation has been practiced
