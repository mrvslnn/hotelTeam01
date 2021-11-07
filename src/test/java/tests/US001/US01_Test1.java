package Tests.US001;

import org.testng.annotations.Test;
import pages.US001_Page.US01Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class US01_Test1 {
    @Test
    public void test() {


        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        US01Page loginPage = new US01Page();
        loginPage.login.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        loginPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        loginPage.submit.click();
        System.out.println(loginPage.başarılı.getText());
        Driver.closeDriver();
    }
}
