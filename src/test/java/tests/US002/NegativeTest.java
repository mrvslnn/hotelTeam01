package tests.US002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US001_Page.US01Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.concurrent.TimeUnit;

public class NegativeTest extends TestBaseRapor {
    @Test
    public void test() {
        extentTest=extentReports.createTest("Negatif Test ");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        extentTest.info("Hotel sayfasına girildi");
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        US01Page loginPage = new US01Page();
        loginPage.login.click();
        extentTest.info("Hotel sayfasına click edildi");

        loginPage.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");
        loginPage.password.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        extentTest.info("Geçersiz Kullanıcı adı başarılı bir şekilde girildi");
        loginPage.submit.click();
        extentTest.info("Butona tıklanıldı");
        Assert.assertTrue(loginPage.tryAgain.isDisplayed());
        extentTest.info("Başarısız yazısı görüldü");

        Driver.closeDriver();

    }
}