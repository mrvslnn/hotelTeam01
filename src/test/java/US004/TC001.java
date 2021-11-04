package US004;

import org.testng.annotations.Test;
import pages.US004_pages;
import utilities.ConfigReader;
import utilities.Driver;

public class TC001 {
    public class TC_0401 {
        @Test
        public void test() {

            Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

            US004_pages us004Pages = new US004_pages();
            us004Pages.ilkLoginLinki.click();
            us004Pages.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
            us004Pages.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
            us004Pages.loginButonu.click();
            us004Pages.hotelManagementLinki.click();

        }
    }}
