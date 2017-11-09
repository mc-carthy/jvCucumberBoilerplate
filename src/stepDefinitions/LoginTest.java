package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	
	WebDriver driver;
	String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

	@Given("^user is on the login page$")
	public void user_is_on_the_login_page () {
		driver = utilities.DriverFactory.open("firefox");
		driver.get(url);
	}
	
	@When("^user enters valid credentials$")
	public void user_enters_valid_credentials () {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@When("^user enters username (.*)$")
	public void user_enters_username (String username) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	@And("^user enters password (.*)$")
	public void user_enters_password (String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	@And("^user submits the login form$")
	public void user_submits_the_login_form () {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@Then("^user sees login confirmation$")
	public void user_sees_login_confirmation () {
		String message = driver.findElement(By.id("conf_message")).getText();
		Assert.assertTrue(message.contains("Logged in successfully"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
