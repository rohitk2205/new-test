package stepdefination;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Resources.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepdefination extends Utils {

	WebDriver driver;

	@Given("^user navigates to url$")
	public void user_navigates_to_url() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ROHIT\\OneDrive\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(getGlobalValue("baseURl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[text()='GET IN TOUCH']")).click();
	}

	@Then("^checks all menu links$")
	public void checks_all_menu_links() throws Throwable {
		String link = "window.open('academy-lms','_blank');";
		((JavascriptExecutor) driver).executeScript(link);
		link = "window.open('brain-science','_blank');";
		((JavascriptExecutor) driver).executeScript(link);
		link = "window.open('resources','_blank');";
		((JavascriptExecutor) driver).executeScript(link);
		link = "window.open('about-growth-engineering','_blank');";
		((JavascriptExecutor) driver).executeScript(link);
		link = "window.open('contact','_blank');";
		((JavascriptExecutor) driver).executeScript(link);
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
		}
		driver.quit();
	}

	@When("^user enter the details$")
	public void user_enter_the_details() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(getGlobalValue("Name"));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getGlobalValue("Email"));
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(getGlobalValue("telephone"));
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(getGlobalValue("Company_name"));

		WebElement drop = driver.findElement(By.xpath("//select[@name='country_']"));
		Select dropdown = new Select(drop);
		dropdown.selectByVisibleText("United States");

		Actions action = new Actions(driver);
		WebElement x = driver.findElement(By.xpath("//*[text()='501-1000']"));
		action.moveToElement(x).click().build().perform();

		WebElement dro = driver.findElement(By.xpath("//select[@name='role_description']"));
		Select drop1 = new Select(dro);
		drop1.selectByVisibleText("CEO or Managing Director");

		WebElement dro2 = driver.findElement(By.xpath("//select[@name='what_is_the_purpose_of_your_enquiry_']"));
		Select drop2 = new Select(dro2);
		drop2.selectByVisibleText("To share how I can help Growth Engineering");

		driver.findElement(By.xpath("//*[@type='checkbox']")).click();
	}

	@Then("^user submits the form$")
	public void user_submits_the_form() throws Throwable {
// submit the form
		driver.quit();
	}

}
