package com.estafet.learning.sprint7;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static com.estafet.learning.sprint7.Globals.tablesToWorkWith3;

@RunWith(Cucumber.class)
@CucumberOptions(
        //tags = "(@special)",
        //tags = "(@general or @data-generation or @functions) and not (@general and @cleaning)",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        features = "classpath:/features/com.estafet.learning.sprint7",
        glue = "com.estafet.learning.sprint7")

public class CollegeBookTestRunner {


}
