package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class NegativeTest {

    @Test
    public void gecersizPassword(){
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(Driver.getDriver());
         Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

         concortHotelPage.login.click();
        concortHotelPage .username.sendKeys("manager2");
        concortHotelPage .password.sendKeys("Man1ager!");
        concortHotelPage .submit.click();


        Assert.assertTrue(concortHotelPage.tryAgain.isDisplayed());




















    }


}
