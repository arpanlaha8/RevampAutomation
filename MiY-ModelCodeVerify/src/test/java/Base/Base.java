package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public String password = null;
	public String username = null;
	public String bikeName = null;
	public WebDriver driver;
	
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("Prop.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        bikeName = properties.getProperty("bike");
        String url = properties.getProperty("url");
        
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
