package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test(description="Positive TestCase")
    public void testValidLogin() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickMakeAppointment();
        login.login("John Doe", "ThisIsNotAPassword");
        

        Assert.assertTrue(driver.getPageSource().contains("Make Appointment"), "Login failed with valid credentials!");
      
    }

    @Test(description="Negative TestCase",enabled=false)
    public void testInvalidLogin() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickMakeAppointment();
        login.login("invalidUser", "wrongPassword");

        Assert.assertTrue(driver.getPageSource().contains("Login failed"), "Error message not shown for invalid login!");
    }

    @Test(description="Negative TestCase",enabled=false)
    public void testEmptyLoginFields() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage login = new LoginPage(driver);

        login.login("", "");

        Assert.assertTrue(driver.getPageSource().contains("Login failed"), "Empty login fields not handled properly!");
    }


}
