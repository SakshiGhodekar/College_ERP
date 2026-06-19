package pages.Student_Information;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentPage {

    WebDriver driver;

    public StudentPage(WebDriver driver) {
        this.driver = driver;
    }

 
    
    By studentModule = By.xpath("//*[contains(text(),'Student Information')]");
    By searchBox = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/span/input");
    //By searchBtn = By.id("searchBtn");
    By result = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/table");

   
    public void openStudentModule() {

        System.out.println("Current URL : " + driver.getCurrentUrl());
        System.out.println("Page Title : " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(studentModule));

        driver.findElement(studentModule).click();
    }

    public void searchStudent(String value) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	WebElement box = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(searchBox)
    	);

    	box.clear();
    	box.sendKeys(value);
    }

    public boolean isResultDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(result));

            List<WebElement> results = driver.findElements(result);

            System.out.println("Tables found: " + results.size());

            return results.size() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}