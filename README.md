#Facebook UI Automation

A BDD API Automation framework for UI.

#Tech Stack

1. JAVA
2. Cucumber BDD with Java 8 and Junit
3. Spring Dependency Injection
4. Gradle as build tool
5. Extent Reports
6. Code coverage using Jacoco


#Project Structure

**src/main**: can be used by to create API's

**src/test**: contains code to perform integration/regression tests

**src/test/resources:** contains everything which is not JAVA

**src/test/java:** contains everything which is JAVA

    TestRunner: Entry point for execution
    FacebookSteps: Stepdefinition for the Facebook.feature file
    ServiceUtil: All the service call related functions resides here
    ServiceWorld: A World component used for sharing the objects eithin the scenarios/steps for an execution
    ServiceConfig: Spring Configuration class
    
#Execution Steps

1. Clone the repo
2. Set JAVA_HOME and GRADLE_HOME on your system(if not already done)
3. Go to src/test/resources/test.properties and update the value for usrename and password or put it in example section of Facebook.feature
4. Open command prompt or terminal
5. Run the following command:
    `gradle test`
6. Find the HTML Extent report in the directory
    `test-output/html-report/test-report.html`
    
 * *Note: These steps are reusable and are parameterized to make request based on multiple parameters. The test coverage for creation of any kind of JIRA issue type can be performed with multiple combinations, without rewriting any code.
