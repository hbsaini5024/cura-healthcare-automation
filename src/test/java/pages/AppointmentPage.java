package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
	
	WebDriver driver;

    By facilityDropdown = By.id("combo_facility");
    By readmissionCheckbox = By.id("chk_hospotal_readmission");
    By medicaidRadio = By.id("radio_program_medicaid");
    By visitDate = By.id("txt_visit_date");
    By commentBox = By.id("txt_comment");
    By bookBtn = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void bookAppointment(String facility, String date, String comment) throws InterruptedException {
        new Select(driver.findElement(facilityDropdown)).selectByVisibleText(facility);
        driver.findElement(readmissionCheckbox).click();
        driver.findElement(medicaidRadio).click();
        driver.findElement(visitDate).sendKeys(date);
        driver.findElement(commentBox).sendKeys(comment);
        
        Thread.sleep(2000);
        driver.findElement(bookBtn).click();
    }


}
