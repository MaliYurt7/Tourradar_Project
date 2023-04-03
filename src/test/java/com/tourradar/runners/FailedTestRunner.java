package com.tourradar.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-cucumber-report.html"},
        features = "@target/rerun.txt",
        glue = "com/tourradar/step_definitions"

)

public class FailedTestRunner {
}
