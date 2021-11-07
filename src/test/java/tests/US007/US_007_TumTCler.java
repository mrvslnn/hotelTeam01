package Tests.US007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US007_Page.US_007_Pages;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class US_007_TumTCler {
    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        US_007_Pages us_007_pages = new US_007_Pages();
        us_007_pages.login.click();
        us_007_pages.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        us_007_pages.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        us_007_pages.submit.click();
        us_007_pages.management.click();
        us_007_pages.roomReservation.click();
        us_007_pages.addRoomReservation.click();

        // TC_002 dropdown
       Thread.sleep(3000);
        Select select = new Select(us_007_pages.selectUser);
        select.selectByValue("2");
        Thread.sleep(3000);
        Select selects = new Select(us_007_pages.selectId);
        selects.selectByValue("50");
        Thread.sleep(3000);

        // TC_003 textboxlar
       us_007_pages.Price.sendKeys("500");
       us_007_pages.DateStart.sendKeys("12.12.2021" + Keys.ENTER);
       us_007_pages.DateEnd.sendKeys("12.12.2022" + Keys.ENTER);
       us_007_pages.AdultAmount.sendKeys("2");
       us_007_pages.ChildrenAmount.sendKeys("1");
       us_007_pages.ContactNameSurname.sendKeys("Erkan KAYA");
       us_007_pages.ContactPhone.sendKeys("5568976542");
       us_007_pages.ContactEmail.sendKeys("erkan@gmail.com");
       us_007_pages.Notes.sendKeys("Kral Dairesi");

       //TC_004 Radio Button
       us_007_pages.Approved.click();
       us_007_pages.IsPaid.click();

       // TC_005 Save
       us_007_pages.Save.click();
       Thread.sleep(3000);
       us_007_pages.Ok.click();
        Driver.closeDriver();

    }
}