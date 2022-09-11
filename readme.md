
# Getting Started
## Microservice app
### Project Setup
1. Install MySQL Server, mySql Workbench, or use DBeaver or an equivalent DBMS that can run MySQL DBS
2. Alternatively, run mySQL container using docker for easy setup.
3. Run app using ```mvn clean install```, or ```mvn spring-boot:run```

Java Version: 11

## Run Commands

### Running Locally without Docker
<Spring Profile = Default>
This instructions will invoke configurations defined in application.properties (Default profile). 
This will run the app in the local environment.

Make sure a SQL server is running locally. Take note of the port it is listening to (usually 3306)
If SQL server is not listening on port 3306, configure it to run on port 3306.

Otherwise, check application.properties datasource field. Make sure the url is pointing to the right port and that the credentials are correct.
```aidl
spring.datasource.url=jdbc:mysql://localhost:3306/peerTutor?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=my-secret-pw
```
Then, start spring boot app with either of these commands:
```aidl
mvn spring-boot:run
mvn clean install
```

