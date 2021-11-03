package Tests;

import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class TC1_US3_Login extends TestBase {
    @Test
    public void test1(){

        driver.get(ConfigReader.getProperty("CHQAUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        concortHotelPage.ilkLoginButton.click();

        concortHotelPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAValidusername"));

        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        concortHotelPage.ikinciLoginButton.click();

    }

}
