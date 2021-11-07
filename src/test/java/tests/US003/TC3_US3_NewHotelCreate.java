package tests.US003;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC3_US3_NewHotelCreate {

    @Test
    public void test3() throws InterruptedException {

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.concortHotelLogin(); // Birinci test methodunu kullandim
        qaConcortPage.buttonsClick();  // Ikinci test methodunu kullnadim

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

        Select select=new Select(qaConcortPage.selectIDGroup);
        select.selectByIndex(1);

        qaConcortPage.saveButton.click();

        Thread.sleep(2000);

        Assert.assertTrue(qaConcortPage.successfullyTextElement.isEnabled());

        qaConcortPage.okButton.click();

        Driver.closeDriver();

    }

}
