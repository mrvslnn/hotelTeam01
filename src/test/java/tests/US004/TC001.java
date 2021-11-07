package Tests.US004;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.US004_Page.US004_pages;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class TC001 {

        @Test
        public void test() throws InterruptedException {

            Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

            US004_pages us004Pages = new US004_pages();
            us004Pages.ilkLoginLinki.click();
            us004Pages.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
            us004Pages.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
            us004Pages.loginButonu.click();
            us004Pages.hotelManagementLinki.click();
            us004Pages.hotelListLink.click();
            us004Pages.detailsButonu.click();
            Thread.sleep(2000);
            us004Pages.addHotelCodeKutusu.sendKeys("19027-6947");
            System.out.println("ilk sayfanin handle değeri :" + Driver.getDriver().getWindowHandle());
            String ilkSayfaninHandleDegeri = Driver.getDriver().getWindowHandle();
            Set<String> tumWindowHandlelari = Driver.getDriver().getWindowHandles();
            System.out.println("Tum Handlelar : " + tumWindowHandlelari);

            String ikinciWindowHandleDegeri = "";
            for (String each : tumWindowHandlelari) {
                if (!each.equals(ilkSayfaninHandleDegeri)) {
                    ikinciWindowHandleDegeri = each;
                }
            }

            System.out.println("ikinci sayfa handle değeri :" + ikinciWindowHandleDegeri);
            Driver.getDriver().switchTo().window(ikinciWindowHandleDegeri);

            us004Pages.addHotelCodeKutusu.clear();
            us004Pages.addHotelCodeKutusu.sendKeys("1234"+ Keys.ENTER);


            us004Pages.okButonu.click();
            Driver.closeDriver();

        }

        }

