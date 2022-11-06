package com.sprint3.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                //"pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },

        features = "src/test/resources/features",
        glue = "com/sprint3/step_definitions",
        dryRun = false,
        tags = "@smoke",
        publish = true


)
public class CukesRunner {

}


