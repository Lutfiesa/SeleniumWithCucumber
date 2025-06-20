package com.lutfi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.lutfi"},
        features = {"src/test/resources"},
        plugin = {"pretty","html:reports/cucumber.html","json:reports/cucumber.json"}
)
public class CucumberTest {
}
