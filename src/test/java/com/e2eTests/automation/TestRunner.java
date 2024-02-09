package com.e2eTests.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/spec/features"},
		//glue = {""},
		
		plugin = { "pretty","html:target/cucumber-report-html", "json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		tags = ("@typeClick"),
		
		monochrome = true
		)

public class TestRunner {
	


}
