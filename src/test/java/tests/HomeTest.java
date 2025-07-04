package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.BaseTest;

public class HomeTest extends BaseTest {
	
	@Test
    public void testHomePageLoads() {
        String expectedTitle = "CURA Healthcare Service";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Homepage title mismatch!");
    }

    @Test
    public void testMakeAppointmentButton() {
        HomePage home = new HomePage(driver);
        home.clickMakeAppointment();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Make Appointment button did not redirect to login page!");
    }


}
