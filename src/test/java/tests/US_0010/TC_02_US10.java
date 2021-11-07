package tests.US_0010;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US_0010_ConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class TC_02_US10 extends TestBaseRapor {
    @Test
    public void testCase1() throws InterruptedException {
        extentTest=extentReports.createTest("HoteL Kullanıcı giriş bilgileri: ");

        Driver.getDriver().get(ConfigReader.getProperty("ProjeCHQAUrl"));
        extentTest.info("Hotel kullanıcı girişi  sayfasına gidildi");

        US_0010_ConcortHotelPage concortHotelPage = new US_0010_ConcortHotelPage();
        concortHotelPage.LoginLinki.click();
        extentTest.info("Butona basıldı");

        concortHotelPage.usernameBox.sendKeys(ConfigReader.getProperty("ProjeCHUsername"));
        extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");

        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("ProjeCHPassword"));
        extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");
        concortHotelPage.LoginButonu.click();
        extentTest.info("Butona tıklanıldı");

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
