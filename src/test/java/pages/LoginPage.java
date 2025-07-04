package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;

    By usernameField = By.id("txt-username");
    By passwordField = By.id("txt-password");
    By loginBtn = By.id("btn-login");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }



}
