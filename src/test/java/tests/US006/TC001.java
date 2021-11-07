package tests.US006;

import org.testng.annotations.Test;
import pages.US006_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC001 extends TestBaseRapor {
    QAConcortPage qaConcortPage;

    @Test
    public void test() {
        extentTest=extentReports.createTest("15 Numaralı odalı Kaydi : ");
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        extentTest.info("Hotel sayfasına gidildi");
        qaConcortPage =new QAConcortPage();


        qaConcortPage.login.click();
        extentTest.info("Butona basıldı");

        qaConcortPage.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");
        qaConcortPage.loginButonu.click();
        extentTest.info("Butona basıldı");
        qaConcortPage.hotelManagement.click();

        extentTest.info("Butona tıklanıldı");

        qaConcortPage.hotelRooms.click();
        qaConcortPage.roomId.sendKeys("15");
        extentTest.info("Başarılı bir şekilde 15 numaralı oda rezervasyonu yapıldı");


        qaConcortPage.roomSearch.click();


        Driver.closeDriver();

    }
}