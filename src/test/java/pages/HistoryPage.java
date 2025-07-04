package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage {
	
	WebDriver driver;
	
	public HistoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By menuBar = By.id("menu-toggle");
	By historyTab = By.xpath("//a[@href='history.php#history']");
	
	public void checkHistory() throws InterruptedException {
		
		driver.findElement(menuBar).click();
		Thread.sleep(2000);
		
		driver.findElement(historyTab).click();
		
	}

}
