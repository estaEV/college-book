package com.estafet.learning.sprint7;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html"},
        features = "classpath:/features/com.estafet.learning.sprint7",
        glue = "com.estafet.learning.sprint7")

public class CollegeBookTestRunner {
}
