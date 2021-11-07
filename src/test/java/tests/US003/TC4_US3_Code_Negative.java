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

public class TC4_US3_Code_Negative extends TestBaseReports {
    @Test
    public void test4() throws InterruptedException {

        extentTest=extentReports.createTest("New Hotel Create NEGATIVE Test","Eksik Box durumunda Yeni otel girisinin yapilamadigi test edilir");
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.concortHotelLogin();
        qaConcortPage.buttonsClick();
        extentTest.pass("Ilgili linkler saglikli Calisiyor");

        Thread.sleep(2000);

        Actions actions = new Actions(Driver.getDriver());

        actions.click(qaConcortPage.codeBox).
                sendKeys(ConfigReader.getProperty("CHQAInvalidCodebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQANamebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAAdressbox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAPhonebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAEmailbox")).
                sendKeys(Keys.PAGE_DOWN).perform();

        extentTest.pass("Code Box eksik girildi");

        Select select = new Select(qaConcortPage.selectIDGroup);
        select.selectByIndex(1);
        extentTest.pass("Drop downda secim yapildi");

        qaConcortPage.saveButton.click();
        extentTest.pass("kaydet butonuna tiklandi");

        Thread.sleep(2000);

        String exceptedResult="SAVE";
        String actuelResult=qaConcortPage.saveButton.getText();

        Assert.assertEquals(actuelResult, exceptedResult);
        extentTest.pass("Eksik box durumunda otel kayit islemi yapilamadigi goruldu");

        Driver.closeDriver();

    }
}
