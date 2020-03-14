# Wholesale Engineering App

This is a backend service to retrieve account and account transaction details from the system.

Uses memory inbuild database (H2) for demonstration purpose and Liquibase to manage database changes and deployement.

Build:
Maven

Deployment
Build the maven project and run the spring boot application or open command prompt in target directory and run below command:

java -jar WholesaleEngineeringApp-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=dev/prod {Optional to provide the active profiles. If no profile provided, it will pick up default}

Once application has started, hit below URLs on browser/Postman app/curl command in cmd
1. Retrieve all accounts from the system:
  http://localhost:8080/accounts/allAccounts
2. Retrieve transaction details for an account
  http://localhost:8080/accounts/getTransactionData/561982430

Currently valid account numbers are: 585309209, 79107454, 321143048, 561982430, 528103765, 328745968

For account number not present in system, appropriate message is displayed.

