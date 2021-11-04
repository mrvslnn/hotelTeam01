package US004;

import org.testng.annotations.Test;
import pages.US004_pages;
import utilities.ConfigReader;
import utilities.Driver;

public class TC002 {
    @Test
    public void test() {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        US004_pages US_004_page = new US004_pages();
        US_004_page.ilkLoginLinki.click();
        US_004_page.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        US_004_page.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        US_004_page.loginButonu.click();
        US_004_page.hotelManagementLinki.click();
        US_004_page.hotelListLink.click();
        US_004_page.addHotelLink.click();
    }
}
