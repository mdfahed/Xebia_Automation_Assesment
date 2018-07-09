package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/SearchFlights.feature" }, glue = {
		"classpath:stepDefinitions" }, plugin = { "pretty", "html:test-output", "json:json_output/cucumber.json",
				"junit:junit_xml/cucumber.xml" }, monochrome = true, strict = true, dryRun = false)
public class SearchFlightsTestRunner {

}
