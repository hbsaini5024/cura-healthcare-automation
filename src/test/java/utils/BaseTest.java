package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;
	@BeforeMethod
	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Optional: disable automation warning & infobars
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("disable-infobars");
        
        options.addArguments("--incognito");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
