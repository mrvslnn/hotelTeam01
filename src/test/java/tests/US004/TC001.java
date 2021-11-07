package tests.US004;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.US004_Page.US004_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Set;

public class TC001 extends TestBaseRapor {

        @Test
        public void test() throws InterruptedException {

            extentTest=extentReports.createTest("Windows Handle ile İkinci Sayfaya Giriş :");

            Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
            extentTest.info("Hotel sayfasına gidildi");

            US004_pages us004Pages = new US004_pages();
            us004Pages.ilkLoginLinki.click();
            extentTest.info("Butona basıldı");
            us004Pages.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
            extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");
            us004Pages.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
            extentTest.info("Geçerli Kullanıcı şifresi başarılı bir şekilde girildi");
            us004Pages.loginButonu.click();
            extentTest.info("Butona tıklanıldı");
            us004Pages.hotelManagementLinki.click();
            extentTest.info("Hotelmanagement linkine tıklandı");
            us004Pages.hotelListLink.click();
            us004Pages.detailsButonu.click();
            extentTest.info("Detail Butonunana tıklanıldı");
            Thread.sleep(2000);
            us004Pages.addHotelCodeKutusu.sendKeys("19027-6947");
            extentTest.info("Code kutusu dolduruldu");
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
            extentTest.info("Butona tıklanıldı ve sayfa handle edildi");


            Driver.closeDriver();



        }

        }

