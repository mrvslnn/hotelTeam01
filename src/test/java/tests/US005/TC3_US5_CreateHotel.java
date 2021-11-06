package tests.US005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US005_Page.US_005_QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC3_US5_CreateHotel {
    @Test
    public void RoomCreateTest() throws InterruptedException {

        US_005_QAConcortHotelPage US005QaConcortHotelPage = new US_005_QAConcortHotelPage();

        US005QaConcortHotelPage.ConcortHotelLogin();// Birinci test calistirdim
        US005QaConcortHotelPage.buttonsClick(); // Ikinci test methodu calistirildi


        US005QaConcortHotelPage.addHotelCodeKutusu.sendKeys("1010");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys("Sternn").
                sendKeys(Keys.TAB).
                sendKeys("Frankfurt").
                sendKeys(Keys.TAB).
                sendKeys("1234567").
                sendKeys(Keys.TAB).
                sendKeys("sa@gmail.com").perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.TAB).perform();

        Select select = new Select(US005QaConcortHotelPage.addHotelDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddHotelDropdownOption"));
        Thread.sleep(2000);

        // 8. Save butonuna basin.
        US005QaConcortHotelPage.addHotelSave.click();

        // 9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(2000);
        Assert.assertTrue(US005QaConcortHotelPage.addHotelSuccesfullYazisi.isDisplayed());

        //10. OK butonuna tıklayın.
        US005QaConcortHotelPage.addHotelAllertOk.click();

        //Driver.closeDriver();
    }
}
