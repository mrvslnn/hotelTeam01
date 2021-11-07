package tests.US009;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC04_US0009_OtelKayit {
    @Test
    public void test3() throws InterruptedException {

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.concortHotelLogin(); // Birinci test methodunu kullandim
        qaConcortPage.buttonsClick();  // Ikinci test methodunu kullnadim

        Thread.sleep(2000);

        Actions actions=new Actions(Driver.getDriver());

        actions.click(qaConcortPage.codeBox).
                sendKeys(ConfigReader.getProperty("CHQAUS9codebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAUS9namebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAUS9addressbox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAUS9phonebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAUS9emailbox")).
                sendKeys(Keys.PAGE_DOWN).perform();


        Select select=new Select(qaConcortPage.selectIDGroup);
        select.selectByIndex(1);

        qaConcortPage.saveButton.click();

        Thread.sleep(2000);

        Assert.assertTrue(qaConcortPage.successfullyTextElement.isEnabled());

        qaConcortPage.okButton.click();

        Driver.closeDriver();

    }


}
