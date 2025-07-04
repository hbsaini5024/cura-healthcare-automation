package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AppointmentPage;
import pages.HistoryPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class HistoryTest extends BaseTest {
	
	@Test
	public void checkHistory() throws InterruptedException {
		HomePage home = new HomePage(driver);
	    LoginPage login = new LoginPage(driver);
	    AppointmentPage appointment = new AppointmentPage(driver);
	    HistoryPage history = new HistoryPage(driver);
	    
	    home.clickMakeAppointment();
	    login.login("John Doe", "ThisIsNotAPassword");
	    
	    try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept(); // or alert.dismiss();
            System.out.println("Alert Accepted");
        } catch (Exception e) {
            System.out.println("No alert present.");
        }
        
        appointment.bookAppointment("Seoul CURA Healthcare Center", "30/07/2025", "Emergency Checkup");
        
        Thread.sleep(2000);
        
        history.checkHistory();
        
        Thread.sleep(2000);
        
        Assert.assertTrue(driver.getPageSource().contains("History"), "We are not history Page!");
        
        
        
	}

}
