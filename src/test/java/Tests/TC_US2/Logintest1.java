package Tests.TC_US2;

import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Logintest1 {
    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ConcortHotelPage concorthotel = new ConcortHotelPage();
        concorthotel.login.click();
        concorthotel.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        concorthotel.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        concorthotel.submit.click();














    }
}