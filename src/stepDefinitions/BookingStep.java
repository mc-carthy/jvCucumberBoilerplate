package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingStep {
	
	WebDriver driver;
	String url = "https://www.aquasana.co.uk/";

	@Given("^I am on the Aquasana home page$")
	public void i_am_on_the_aquasana_home_page () {
		driver = utilities.DriverFactory.open("chrome");
		driver.get(url);
	}
	
	@When("^I select Spa Days")
	public void i_select_spa_days() {
		driver.findElement(By.xpath("//button[contains(.,'Spa Days')]")).click();
	}
	
	@When("^I select (.*) from the Choose Your Spa dropdown$")
	public void i_select_sherwood_forest_from_the_choose_your_spa_dropdown(String venue) {
		new Select(driver.findElement(By.id("spaVillageCode"))).selectByVisibleText(venue);
	}
	
	@When("^I choose tomorrow from the Date dropdown$")
	public void i_choose_a_date_from_the_date_dropdown() {
		driver.findElement(By.id("spaDayDatePicker")).sendKeys("\uE014", "Enter");
	}

	@When("^I set (\\d+) days on the Flexibility dropdown$")
	public void i_choose_days_from_the_flexibility_dropdown(int days) {
		String dayString = String.valueOf(days);
		new Select(driver.findElement(By.id("dayDifference"))).selectByValue(dayString);
	}

	@When("^I click Search Now$")
	public void i_click_search_now() {
		driver.findElement(By.xpath("//button[contains(.,'Search now')]")).click();
	}

	@Then("^I should see many search results$")
	public void i_should_see_many_search_results() {
		// TODO - The below statements also return the articles with a class of 'is-hidden'
		// Look into return a list of elements containing more than one class
		List<WebElement> results = driver.findElements(By.xpath("//section[@class='b-search-results']/article[@class='b-product']"));
		Assert.assertTrue(results.size() > 0);
	}

	@When("^I select More Information on the number (\\d+) result$")
	public void i_select_more_information_on_the_first_result(int occurance) {
		driver.findElement(By.xpath("//section[@class='b-search-results']/article[@class='b-product'][" + occurance + "]/div[@class='b-product__body']/div[@class='b-product__desc']/a")).click();
	}

	@When("^I select the first available date")
	public void i_select_the_first_available_date() {
		driver.findElement(By.cssSelector("#option-0")).click();
	}
	
	@When("^I choose (\\d+) guests$")
	public void i_choose_guests(int numberOfGuests) {
		String dayString = String.valueOf(numberOfGuests);
		new Select(driver.findElement(By.xpath("//*[@id=\"0\"]/select"))).selectByValue(dayString);
	}
	
	@When("^I book my selection")
	public void i_book_my_selection() {
		driver.findElement(By.xpath("//a[contains(.,'Book Spa days')]")).click();
	}
	
	@After
	public void tearDown() {
//		driver.quit();
	}
}
