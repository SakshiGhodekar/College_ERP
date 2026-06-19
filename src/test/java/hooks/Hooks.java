package hooks;

import java.io.File;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends BaseClass {

 @Before
 public void setup(Scenario scenario) {
	
     System.out.println("Scenario Start: " + scenario.getName());

     loadConfig();
     launchBrowser();

   
 }

 @After
 public void tearDown(Scenario scenario) {

	    try {

	    	if (scenario.isFailed()) {

	    	    String folderPath = "ExtentReports/screenshots";

	    	    String imgPath = captureScreen(
	    	            scenario.getName() + "_" + System.currentTimeMillis(),
	    	            folderPath
	    	    );

	    	    byte[] fileContent = java.nio.file.Files.readAllBytes(
	    	            new File(imgPath).toPath()
	    	    );

	    	    scenario.attach(fileContent, "image/png", "Failed Screenshot");

	    	    System.out.println("Test Failed : " + scenario.getName());
	    	}
	        else {
	            System.out.println("Test Passed : " + scenario.getName());
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally {

	        // 🔥 FIX 2: safe browser close
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
}
