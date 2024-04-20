# Introduction

Test automation project for exchange rate API (https://www.exchangerate-api.com) developed using Cucumber Java.

# Pre-requisite

1. Environment is setup with JDK 17

# Framework

Application is developed using Java and Cucumber framework.
Framework includes following

1. Maven wrapper to execute script via maven commands `./mvnw`
2. Log4j2 is used to log request and response of api `./target/report/logs`
3. Lombok and Jackson-databind is used for easy conversion of response json to object.
4. Owner library is used for reading api configuration from properties
   file `src/main/resources/config/config.properties`
5. Maven surefire plugin is setup in pom which calls `src/test/resources/runner/regression-test.xml` which is calling
   cucumber runner.

### dependencies

| Library                                     | Description                                                      |
|---------------------------------------------|------------------------------------------------------------------|
| org.projectlombok:lombok                    | Used for default getter, setter and builder class for POJO       |
| com.fasterxml.jackson.core.jackson-databind | Used for converting json string to Java Object                   |
| io.rest-assured.rest-assured                | Used for specifying request and response and performign API call |
| io.cucumber.cucumber-java                   | Used for writing cucumber test in Gherkins language              |
| io.cucumber.cucumber-testng                 | Used for assertions and test execution                           |
| org.aeonbits.owner.owner                    | Used for reading base api details from config.properties file    |

# Build and Test

### Run locally

1. Clone repository
2. Navigate to the root folder of project
3. Run maven command
    ```
    ./mvnw clean test
    ```
4. After script is executed successfully, report and logs can be verified from below location.

    ```
    <root_directory>/target/report/cucumber/cucumber-reports.html
    <root_directory>/target/report/logs/myapp.log
    ```

### Run with Azure pipeline

1. Connect to your Azure DevOps account
2. Navigate to Pipelines tab
3. Create new pipeline
4. Selected Source repository as GIT_HUB and provide git location
5. Select `Existing Azure pipelines YAML file` task
6. Select code branch as `main`
7. Select YAML path as `<root_directory>/azure-pipeline.yml`
8. Run pipeline
9. Once execution is completed, `target/report` folder will be published in Azure artifact.

# Code

| Package                      | File Type         | File                | Description                                                                               |
|------------------------------|-------------------|---------------------|-------------------------------------------------------------------------------------------|
| com.r3.api.endpoint.request  | Class             | ExchangeRateRequest | Class is used to perform GET Api call and return the response object                      |
| com.r3.api.endpoint.response | Class             | ExchangeRateRequest | Class is returning Object of the JSON returned in response body.                          |
| com.r3.api.endpoint          | Class             | BaseRequest         | Base class defining RestAssured.baseUrl for API call                                      |
| com.r3.api.endpoint          | Class             | BaseResponse        | Base class defining initializing Response Object                                          |
| com.r3.api.endpoint          | Class             | Router              | Class providing URL end point for API call                                                |
| com.r3.api.model.response    | Class             | GetExchangeRateData | POJO defining structure of response Json                                                  |
| com.r3.config                | Class             | GlobalVariable      | Class defining static variables used during program                                       |
| com.r3.RunConfig             | Interface         | RunConfig           | Interface used by `owner` library to read properties file from `config/config.properties` |
| com.r3.enums                 | Enum              | CurrencyCode        | List all 162 currency codes returned in response                                          |
| com.r3.logger                | RestAssuredLogger | RestAssuredLogger   | Implements RestAssured `Filter` class and logs requests and response data using `Log4j`   |
