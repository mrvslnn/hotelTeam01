package Tests.US003;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReports;

public class TC3_US3_NewHotelCreate extends TestBaseReports {

    @Test
    public void test3() throws InterruptedException {
        extentTest=extentReports.createTest("New Hotel Create Test","Yeni otel girisinin yapilabildigi test edilir");

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.concortHotelLogin(); // Birinci test methodunu kullandim
        qaConcortPage.buttonsClick();  // Ikinci test methodunu kullnadim
        extentTest.pass("Ilgili linkler saglikli Calisiyor");

        Thread.sleep(2000);

        Actions actions=new Actions(Driver.getDriver());

       actions.click(qaConcortPage.codeBox).
               sendKeys(ConfigReader.getProperty("CHQACodebox")).
               sendKeys(Keys.TAB).
               sendKeys(ConfigReader.getProperty("CHQANamebox")).
               sendKeys(Keys.TAB).
               sendKeys(ConfigReader.getProperty("CHQAAdressbox")).
               sendKeys(Keys.TAB).
               sendKeys(ConfigReader.getProperty("CHQAPhonebox")).
               sendKeys(Keys.TAB).
               sendKeys(ConfigReader.getProperty("CHQAEmailbox")).
               sendKeys(Keys.PAGE_DOWN).perform();

        extentTest.pass("Hotel create Boxs calisiyor");

        Select select=new Select(qaConcortPage.selectIDGroup);
        select.selectByIndex(1);

        extentTest.pass("Drop downda secim yapildi");

        qaConcortPage.saveButton.click();

        extentTest.pass("kaydet butonuna tiklandi");

        Thread.sleep(2000);

        Assert.assertTrue(qaConcortPage.successfullyTextElement.isEnabled());

        extentTest.pass("Basarili giris yazisi goruldu");

        qaConcortPage.okButton.click();

        extentTest.pass("Ok butonuna basilarak islem basariyla tamamlandi");

        Driver.closeDriver();

    }

}
