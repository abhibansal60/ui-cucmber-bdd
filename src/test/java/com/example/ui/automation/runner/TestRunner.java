package com.example.ui.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.example.ui.automation.stepdefinitions",
        tags = "@UI",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:test-output/json/cucumber-report.json",
                "pretty"},
        strict = true, monochrome = false)
public class TestRunner {

}
