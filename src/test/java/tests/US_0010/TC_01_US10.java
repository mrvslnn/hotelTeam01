package tests.US_0010;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0010_ConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01_US10 {
    @Test
    public void testCase1() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("ProjeCHQAUrl"));
        US_0010_ConcortHotelPage concortHotelPage=new US_0010_ConcortHotelPage();
        concortHotelPage.LoginLinki.click();
        concortHotelPage.usernameBox.sendKeys(ConfigReader.getProperty("ProjeCHUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("ProjeCHPassword"));
        concortHotelPage.LoginButonu.click();
        concortHotelPage.hotelManagementButonu.click();
        concortHotelPage.HotelRoomsButonu.click();
        Assert.assertTrue (concortHotelPage.ListOfHotelRoomsYazisi.isDisplayed());
        Driver.closeDriver();



    }





}
