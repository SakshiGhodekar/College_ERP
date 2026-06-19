package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class LoginPage extends BaseClass {

    public LoginPage() {
        initPageFactory(this);
    }

    // ✔ safer locator
    @FindBy(xpath = "/html/body/div/nav/div/div/div[2]/div/button[1]")
    WebElement clgLogin;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//*[contains(text(),'Invalid') or contains(text(),'error')]")
    WebElement errorMsg;

    public void clickCollegeLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(clgLogin)).click();
    }

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public boolean isErrorMessageDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Invalid') or contains(text(),'incorrect') or contains(text(),'failed')]")
                )
            );

            return msg.isDisplayed();

        } catch (Exception e) {
            System.out.println("ERROR NOT FOUND IN UI");
            System.out.println(driver.findElement(By.tagName("body")).getText());
            return false;
        }
    }
}


