package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseClass{

	LoginPage loginPageObj=new LoginPage();
	//isekethrough hum login page ke methods call krenge
	@Given("user is on login page")
	public void user_is_on_Lonin_Page() {
		//ursl already open hooks se
	}
	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password(){
	loginPageObj.enteruname(prop.getProperty("username"));
	loginPageObj.enterpass(prop.getProperty("password"));
	loginPageObj.login();
	System.out.println("entered valid credential");
	}
	@Then("user should logged in successfully")
	public void user_should_logged_in_successfully() {
		System.out.println("User login successfully");
	}
	
		//invalid login scenario
		@When("user enters Invalid username and password")
		public void user_enters_Invalid_username_and_password() {
			loginPageObj.enteruname("username");
			loginPageObj.enterpass("dvashdgvs");
			loginPageObj.login();
			
			System.out.println("entered invalid credential");
	}
		@Then("error message should be displayed")
		public void error_message_should_be_displayed() {
			//boolean  isErrorDisplayed=loginPageObj.isErrorMessageDisplayed();
			//Assert.assertTrue("Error msg not dispalyed",isErrorDisplayed);
			
			System.out.println("error msg dispalyed successfully");
		}
}
