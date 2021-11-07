package tests.US009;

import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01_US0009_SiteyeGiris extends TestBaseRapor {
    @Test
    public void test1(){
        extentTest=extentReports.createTest("Müşteri Yeni Hesabi :");

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        extentTest.info("Kayıt sayfasına gidildi");

        QAConcortPage concortHotelPage = new QAConcortPage();

        concortHotelPage.ilkLoginButton.click();
        extentTest.info("Butona Tıklandı");

        concortHotelPage.userNameBox.sendKeys("manager");
        extentTest.info("Geçerli Müşteri kullanıcı giriş ismi oluşturuldu");

        concortHotelPage.passwordBox.sendKeys("Manager1!");
        extentTest.info("Geçerli Müşteri kullanıcı Şifresi  oluşturuldu");
        concortHotelPage.ikinciLoginButton.click();
        extentTest.info("Butona tıklandi");
        Driver.closeDriver();

    }


}
