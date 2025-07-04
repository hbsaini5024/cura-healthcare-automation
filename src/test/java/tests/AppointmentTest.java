package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class AppointmentTest extends BaseTest {
	
	
	
	@Test
    public void testBookAppointment() throws InterruptedException, IOException {
		
		
		
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        AppointmentPage appointment = new AppointmentPage(driver);

        home.clickMakeAppointment();
        login.login("John Doe", "ThisIsNotAPassword");
        
//        Thread.sleep(3000);
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept(); // or alert.dismiss();
            System.out.println("Alert Accepted");
        } catch (Exception e) {
            System.out.println("No alert present.");
        }
        
        appointment.bookAppointment("Seoul CURA Healthcare Center", "30/07/2025", "Routine check-up");
        
        Thread.sleep(2000);

        Assert.assertTrue(driver.getPageSource().contains("Appointment Confirmation"), "Booking failed!");
        
        Thread.sleep(2000);
        
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/screenshot1.png");
        
        FileUtils.copyFile(src, dest);
        
        Thread.sleep(4000);
    }


}
