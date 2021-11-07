package Tests.US010;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US010_Page.US_0010_ConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;


public class TC_02_US10 {
    @Test
    public void testCase1() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("ProjeCHQAUrl"));
        US_0010_ConcortHotelPage concortHotelPage = new US_0010_ConcortHotelPage();
        concortHotelPage.LoginLinki.click();
        concortHotelPage.usernameBox.sendKeys(ConfigReader.getProperty("ProjeCHUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("ProjeCHPassword"));
        concortHotelPage.LoginButonu.click();
        concortHotelPage.hotelManagementButonu.click();
        concortHotelPage.HotelRoomsButonu.click();
        Select select = new Select(concortHotelPage.IDHotelDropDownu);
        select.selectByVisibleText("Yeni Hotel");
        System.out.println(select.getFirstSelectedOption());
        concortHotelPage.ListofHotelRoomsSearchButonu.click();
        Thread.sleep(2000);
        concortHotelPage.ListofHotelRoomsClearButonu.click();
        Driver.closeDriver();

    }
}
