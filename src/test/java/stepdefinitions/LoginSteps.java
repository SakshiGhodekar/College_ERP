
package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseClass {

    LoginPage loginPage = new LoginPage();

    @Given("user is on home page")
    public void home_page() {
        // already opened in hook
    }

    @When("user enters Invalid username and password")
    public void invalid_login() {

        loginPage.clickCollegeLogin();

        loginPage.enterUsername("wronguser@gmail.com");
        loginPage.enterPassword("wrongpass");

        loginPage.clickLogin();
    }

    @When("user enters wrong username and correct password")
    public void wrong_username() {
        loginPage.clickCollegeLogin();

        loginPage.enterUsername("wronguser@gmail.com");
        loginPage.enterPassword("Abc@1234");

        loginPage.clickLogin();
    }

    @When("user enters valid username and password")
    public void valid_login() {
        loginPage.clickCollegeLogin();

        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));

        loginPage.clickLogin();
    }

    @Then("error message should be displayed")
    public void error_msg() {

        // 🔥 ADD THIS LINE (DEBUG STEP)
        System.out.println("========= PAGE SOURCE START =========");
        System.out.println(driver.getPageSource());
        System.out.println("========= PAGE SOURCE END =========");

        boolean result = loginPage.isErrorMessageDisplayed();

        Assert.assertTrue("Error message not displayed", result);
    }

    @Then("user should logged in successfully")
    public void success() {
        System.out.println("Login success");
    }
}


