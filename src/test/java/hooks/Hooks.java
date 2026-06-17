package hooks;

import java.io.File;

//import org.bouncycastle.jcajce.provider.symmetric.ChaCha.BaseCC20P1305;



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
 public void tearDown( Scenario scenario) {
	 if(scenario.isFailed()) {
		 
		 String folderPath="ExtentReports/screenshots";
		 String imgPath=captureScreen(scenario.getName(),folderPath);
		 try {
			 byte[]fileContent=java.nio.file.Files.readAllBytes(new File(imgPath).toPath());
		  scenario.attach(fileContent,"image/png","Failed Screenshots");
		  
		  //extend report
		  String relativePath= "screenshots/"+new File(imgPath).getName();
		  com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(relativePath);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 System.out.println("Test Failed : "+scenario.getName());
		 
	 }else {
		 System.out.println("Test Passed :"+scenario.getName());
		 
	 }
	 closeBrowser();
	 //System.out.println("*****Test Finished********");
 }
}
