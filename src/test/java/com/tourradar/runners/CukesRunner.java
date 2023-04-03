package com.tourradar.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
                },

        features = "src/test/resources/features",
        glue = "com/tourradar/step_definitions",
     //   dryRun = true,
        tags = "@wip"

)

public class CukesRunner {
}
