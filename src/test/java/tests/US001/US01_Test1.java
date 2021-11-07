package tests.US001;

import org.testng.annotations.Test;
import pages.US001_Page.US01Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.concurrent.TimeUnit;

public class US01_Test1 extends TestBaseRapor {
    @Test
    public void test() {

        extentTest=extentReports.createTest("Pozitif Test");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        extentTest.info("Hotel sayfasına gidildi");
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        US01Page loginPage = new US01Page();
        loginPage.login.click();
        extentTest.info("Butona basıldı");
        loginPage.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");
        loginPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        extentTest.info("Geçerli Kullanıcı şifresi başarılı bir şekilde girildi");
        loginPage.submit.click();
        extentTest.info("Butona tıklanıldı");
        System.out.println(loginPage.başarılı.getText());
        extentTest.info("Başarılı yazısı görüldü");

        Driver.closeDriver();

    }



}
