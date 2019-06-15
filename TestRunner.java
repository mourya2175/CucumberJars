package testrunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"pretty","html:reports/test-report",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-test-reports/AutomationReport.html",
		"json:target/cucumber-test-reports/Cucumber.json"},
features="resources",
glue="stepdefinitions",
//dryRun = true,
tags= {"@basic"})

public class TestRunner extends AbstractTestNGCucumberTests {
	
	public static void writeExtentReport() {
	}
}
