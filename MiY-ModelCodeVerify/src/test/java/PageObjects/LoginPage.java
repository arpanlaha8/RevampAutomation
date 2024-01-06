package PageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By loginEmail = By.xpath("//input[@name='emailId']");
	By loginPassword = By.xpath("//input[@name='password']");
	By loginButton = By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[2]/div/button");
//	By nextPageHeader = By.xpath("//*[@id=\"root\"]/div[1]/header/h1");
	By modelDropdown = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div/div[1]/div/div");


	public void enterCredentials(String username, String password) {

		driver.findElement(loginEmail).click();
		driver.findElement(loginEmail).sendKeys(username);
		driver.findElement(loginPassword).click();
		driver.findElement(loginPassword).sendKeys(password);
	}

	public void logIn(String username, String password) {

		enterCredentials(username, password);
		driver.findElement(loginButton).click();

		FluentWait<WebDriver> webdwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
		webdwait.until(ExpectedConditions.elementToBeClickable(modelDropdown));
	}
}
