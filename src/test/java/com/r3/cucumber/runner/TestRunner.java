package com.r3.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.r3.cucumber.steps"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/report/cucumber/cucumber-reports.html",
                "json:target/report/cucumber/cucumber.json",
                "junit:target/report/cucumber/cucumber.xml"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
