package testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:reports/test-report",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-test-reports/AutomationReport.html",
		"json:target/cucumber-test-reports/Cucumber.json"},
features="resources",
glue="stepdefinitions",
dryRun = true,
tags= {"@chrome"})

public class TestRunJunit {

}
