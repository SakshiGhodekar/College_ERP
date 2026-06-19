
package stepdefinitions.Student_Information;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import pages.Student_Information.StudentPage;

public class StudentSteps extends BaseClass {

    LoginPage loginPage;
    StudentPage page;

    public StudentSteps() {
        // ❌ DO NOT initialize driver here
        // driver is already initialized in Hooks (@Before)

        loginPage = new LoginPage();
        page = new StudentPage(BaseClass.driver);   // ✅ use static driver safely
    }

    @Given("admin is logged into the application")
    public void admin_is_logged_into_the_application() {

        // ❌ DO NOT re-create loginPage again here

        loginPage.clickCollegeLogin();
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickLogin();
    }

    @Given("admin is on Student page")
    public void open_page() {
        page = new StudentPage(BaseClass.driver);  // safety re-init
        page.openStudentModule();
    }

    @When("admin searches student by {string}")
    public void search_student(String value) {
        page.searchStudent(value);
    }

    @Then("result should be displayed")
    public void validate() {
    	boolean result = page.isResultDisplayed();
    	Assert.assertTrue("Result not displayed after search", result);
    }
}

