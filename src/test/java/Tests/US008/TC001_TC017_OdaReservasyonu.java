package Tests.US008;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US008_Page.US_008_QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC001_TC017_OdaReservasyonu {
    @Test
    public void odaReservasyonuTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("PCHUrl"));

        US_008_QAConcortHotelPage qaConcortPage= new US_008_QAConcortHotelPage();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        qaConcortPage.pLoginTusu.click();

        Select selectUser=new Select(qaConcortPage.pSelectUser);
        selectUser.selectByValue(ConfigReader.getProperty("CHUserId"));

        Select selectHotelRoom =new Select(qaConcortPage.pSelectHotelRoom);
        selectHotelRoom.selectByValue(ConfigReader.getProperty("CHHotelSecim"));

        Faker faker =new Faker();
        qaConcortPage.pPrice.sendKeys(String.valueOf(faker.number().numberBetween(20,200)));

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        qaConcortPage.pDateStartTakvim.click();
        qaConcortPage.pTakvimSagOk.click();
        qaConcortPage.pStartDay.click();

        qaConcortPage.pDateEndTakvim.click();
        qaConcortPage.pTakvimSagOk.click();
        qaConcortPage.pEndDay.click();

        qaConcortPage.pAdultAmount.sendKeys(ConfigReader.getProperty("CHYetiskinSayisi"));
        actions.sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHCocukSayisi"))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHKullaniciTelefon"))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHKullaniciMesaj"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        qaConcortPage.pSave.click();

        Thread.sleep(2000);

        String expectedYazi=ConfigReader.getProperty("CHRezervasyonOnayYazisi");
        String actualYazi=qaConcortPage.pBasariliYazisiElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi,ConfigReader.getProperty("Rezervasyon yapilamamistir!"));

        Driver.closeDriver();
    }
}
