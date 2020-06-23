package com.example.ui.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.example.ui.automation.stepdefinitions",
        tags = "@conduit",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:test-output/json/cucumber-report.json",
                "pretty"},
        strict = true, monochrome = false)
public class TestRunner {

}
