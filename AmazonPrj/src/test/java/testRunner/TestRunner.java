package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features", glue = "stepDefinitions", tags = "@Regression", plugin = {
		"html:target/cucumber-html-report", "pretty:target/cucumber-pretty.txt" })
//		plugin = "pretty")
public class TestRunner {

}
