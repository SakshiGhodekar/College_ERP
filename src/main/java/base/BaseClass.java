package base;



import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;



public class BaseClass {

	
		// TODO Auto-generated method stub
 public static WebDriver driver;
// public static String BASE_URL = "https://erp.softgridinfo.in/college-admin-login";
 public static Properties prop;
 
 public void loadConfig() {
	 try {
		 prop =new Properties();
		 FileInputStream fis=new FileInputStream("src/main/resources/config/config.properties");
	 prop.load(fis);
	 }catch(Exception e){
		 e.printStackTrace();
		 
	 }
 }
 
 public void launchBrowser() {
	 
	 String browserName=prop.getProperty("browser");
	 if(browserName.equalsIgnoreCase("chrome")) {
		 driver=new ChromeDriver();
	 }else if(browserName.equalsIgnoreCase("firefox")){
		 
		 driver=new FirefoxDriver();
		 
	 }else {
		 System.out.println("browser not supported");
		 
	 }
	 driver.get(prop.getProperty("url"));
	 driver.manage().window().maximize();
 }
 
 // common pagefactory init method
 public void initPageFactory(Object page) {
	 PageFactory.initElements(driver, page);
 }
 public void closeBrowser() {
	 if(driver!=null) {
		 driver.quit();
	 }
 }
 // capture screen method
 public String captureScreen(String testName,String folderPath) {
	 try {
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String path=folderPath +"/" + testName + ".png";
		 
		 File dest=new File(path);
		 dest.getParentFile().mkdir();
		 Files.copy(src.toPath(), dest.toPath());
		 return path;
	 }catch(Exception e) {
		 e.printStackTrace();
		 return null;
	 }
 }
	

}
