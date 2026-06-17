package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/features",
glue= {"stepdefinitions","hooks"},
plugin= {"pretty",
		"html:taget/cucumber-report.html",
		"json:target/cucumber.json",//jenkink imp
		"junit:target/cucumber.xml",//jenkins report parsing ke liye imp
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
monochrome=true
)//grouping controll

public class TestRunner {

	
}
