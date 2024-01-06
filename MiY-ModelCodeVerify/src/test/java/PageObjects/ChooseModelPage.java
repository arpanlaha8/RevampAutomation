package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ChooseModelPage {
	WebDriver driver;

	public ChooseModelPage(WebDriver driver) {

		this.driver = driver;
	}

	By modelDropdown = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div/div[1]/div/div");
	By models = By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div/div[2]/div");
	By configureNowButton = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div/div[3]/div/button");
	By nextPageLoad = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[3]/div[2]/div[2]/button");
	
	public void chooseModel(String username, String password, String bikeName) {
		
		LoginPage logIn_obj = new LoginPage(driver);
		logIn_obj.logIn(username,password);

		driver.findElement(modelDropdown).click();

		List<WebElement> modelList = driver.findElements(models);

		for (WebElement item : modelList) {
			if (item.getText().equalsIgnoreCase(bikeName)) {
				item.click();
				FluentWait<WebDriver> webdwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
						.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
				webdwait.until(ExpectedConditions.elementToBeClickable(configureNowButton));
				driver.findElement(configureNowButton).click();
				logIn_obj.logIn(username,password);
				webdwait.until(ExpectedConditions.elementToBeClickable(nextPageLoad));
				break;
			}
			
		}

	}
}
