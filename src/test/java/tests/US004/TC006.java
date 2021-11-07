package tests.US004;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US004_Page.US004_pages;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class TC006 {
    @Test
    public void tc_0005() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        US004_pages us004Pages = new US004_pages();
        us004Pages.ilkLoginLinki.click();
        us004Pages.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        us004Pages.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        us004Pages.loginButonu.click();
        us004Pages.hotelManagementLinki.click();
        us004Pages.hotelListLink.click();
        us004Pages.detailsButonu.click();

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
        us004Pages.addHotelCodeKutusu.sendKeys("1234"+ Keys.TAB);//failed
        us004Pages.nameButonu.sendKeys(Keys.TAB);
        us004Pages.adresButonu.sendKeys(Keys.TAB);
        us004Pages.phoneButonu.sendKeys(Keys.TAB);
        us004Pages.mailButonu.sendKeys(Keys.TAB);

        Select select = new Select(us004Pages.idGroupHotelEkle);
        select.selectByVisibleText("Hotel Type2");
        Thread.sleep(2000);



        WebElement deleteButonu = Driver.getDriver().findElement(By.xpath("//button[@id='btnDelete']"));
deleteButonu.submit();


        WebElement okButonu = Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='confirm']"));
        okButonu.click();


    }


}
