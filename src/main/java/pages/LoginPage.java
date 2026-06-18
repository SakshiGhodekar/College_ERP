package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		initPageFactory(this);
	}
	@FindBy(xpath="//*[@id=\"root\"]/nav/div/div/div[2]/div/button[1]")
	WebElement clgLogin;
	//username
	@FindBy(id="username")
	WebElement username;
	
	//pass
	@FindBy(id="password")
	WebElement password;
	
	//login button
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div[4]/div/div/div/div/button")
    WebElement login;
	
	
	
	//action
	
	public void enteruname(String user) {
	 username.sendKeys(user);
	}
	public void enterpass(String pass) {
		 password.sendKeys(pass);
		}
	public void login() {
		 login.click();
		}
	public void clgLogin() {
		clgLogin.click();// TODO Auto-generated method stub
		
	}
	
	//validation method
	
	@FindBy(xpath ="/html/body/div[2]/div/div/div/div/span[2]")
	WebElement errorMsg;
	

	public boolean isErrorMessageDisplayed() {
	    return errorMsg.isDisplayed();
	}
	
	
		
}
