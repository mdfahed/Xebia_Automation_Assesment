package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.UtilityLibrary;

public class SearchFlightsStepDefinition {
	WebDriver driver;

	@Given("^Bill has decided to check available flights$")
	public void bill_has_decided_to_check_available_flights() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.emirates.com/ae/english/");

	}

	@When("^he looks at a return trip from \"([^\"]*)\" to \"([^\"]*)\" leaving one week from now$")
	public void he_looks_at_a_return_trip_from_to_leaving_one_week_from_now(String arg1, String arg2) {
		WebElement departureAirport = driver.findElement(By.name("Departure airport"));
		departureAirport.clear();
		departureAirport.sendKeys(arg1);
		driver.findElement(By.xpath("//a/p[contains(text(),'" + arg1 + "')]")).click();
		WebElement arivalAirport = driver.findElement(By.name("Arrival airport"));
		arivalAirport.clear();
		arivalAirport.sendKeys(arg2);
		driver.findElement(By.xpath("//a/p[contains(text(),'" + arg2 + "')]")).click();
		driver.findElement(By.id("search-flight-date-picker--depart")).click();
		String currentDate = driver
				.findElement(By
						.xpath("//table[@aria-labelledby='monthLeft']//tbody[@id='dataLeft']/tr/td[@class='dp-highlight depart-date-selected first']/a"))
				.getAttribute("aria-label");
		String newDate = UtilityLibrary.getDate(currentDate, 7);
		if (driver.findElement(By.xpath("//div[@id='calendarLeft']//span[@id='monthLeft']")).getText()
				.equals(newDate.substring(3))) {
			driver.findElement(By.xpath("//table[@aria-labelledby='monthLeft']//tbody[@id='dataLeft']/tr/td/a[text()='"
					+ newDate.split(" ")[0] + "']")).click();
		} else if (driver.findElement(By.xpath("//div[@id='calendarRight']//span[@id='monthRight']")).getText()
				.equals(newDate.substring(3))) {
			driver.findElement(
					By.xpath("//table[@aria-labelledby='monthRight']//tbody[@id='dataRight']/tr/td/a[text()='"
							+ newDate.split(" ")[0] + "']"))
					.click();
		}

		driver.findElement(By.xpath("//div//input[@id='btnPlanAndBookStartBooking' and @value='Find flights']"))
				.click();

	}

	@Then("^he should be shown the cheapest return ticket from DXB to LHR$")
	public void he_should_be_shown_the_cheapest_return_ticket_from_DXB_to_LHR() {
		String lowestPrice = driver.findElement(By.xpath("//div[@data-target='option-0-1-0']/span")).getText();
		System.out.println(lowestPrice);

	}

}
