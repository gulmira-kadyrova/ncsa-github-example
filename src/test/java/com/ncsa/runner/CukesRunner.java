package com.ncsa.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json", "html:target/html-cucumber-report"},
        features = "src/test/resources/features",
        glue = "com/ncsa/step_definitions",
        tags = "not @ignore"
)
public class CukesRunner {
}
