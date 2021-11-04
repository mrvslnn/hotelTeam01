package Tests.TC_US3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US3_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC8_US3_Email_Negative {

    @Test
    public void test8() throws InterruptedException {

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.concortHotelLogin();
        qaConcortPage.buttonsClick();

        Thread.sleep(2000);

        Actions actions = new Actions(Driver.getDriver());

        actions.click(qaConcortPage.codeBox).
                sendKeys(ConfigReader.getProperty("CHQACodebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQANamebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAAdressbox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAPhonebox")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAInvalidEmailbox")).
                sendKeys(Keys.PAGE_DOWN).perform();


        Select select = new Select(qaConcortPage.selectIDGroup);
        select.selectByIndex(1);

        qaConcortPage.saveButton.click();

        Thread.sleep(2000);

        String exceptedResult="SAVE";
        String actuelResult=qaConcortPage.saveButton.getText();

        Assert.assertEquals(actuelResult, exceptedResult);

        Driver.closeDriver();

    }

}
