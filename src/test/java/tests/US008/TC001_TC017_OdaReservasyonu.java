package tests.US008;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US008_Page.US_008_QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC001_TC017_OdaReservasyonu extends TestBaseRapor {
    @Test
    public void odaReservasyonuTest() throws InterruptedException {
        extentTest=extentReports.createTest("Hotel oda Rezarvasyonu Müşteri bilgileri:  ");
        Driver.getDriver().get(ConfigReader.getProperty("PCHUrl"));
        extentTest.info("Hotel rezarvasyon sayfasına gidildi");

        US_008_QAConcortHotelPage qaConcortPage= new US_008_QAConcortHotelPage();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        extentTest.info("Geçerli Kullanıcı adı başarılı bir şekilde girildi");
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        extentTest.info("Geçerli Kullanıcı şifresi başarılı bir şekilde girildi");
        qaConcortPage.pLoginTusu.click();
        extentTest.info("Butona tıklandı");

        Select selectUser=new Select(qaConcortPage.pSelectUser);
        selectUser.selectByValue(ConfigReader.getProperty("CHUserId"));
        extentTest.info("Müşteri nosu girildi");

        Select selectHotelRoom =new Select(qaConcortPage.pSelectHotelRoom);
        selectHotelRoom.selectByValue(ConfigReader.getProperty("CHHotelSecim"));

        extentTest.info("Oda secimi yapıldı");

        Faker faker =new Faker();
        qaConcortPage.pPrice.sendKeys(String.valueOf(faker.number().numberBetween(20,200)));

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        qaConcortPage.pDateStartTakvim.click();
        extentTest.info(" Müşterinin Hotele Giriş tarihi girildi");
        qaConcortPage.pTakvimSagOk.click();
        extentTest.info(" Müşterinin Hotele çıkıs tarihi girildi");
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
        extentTest.info("Çocuk sayısı Girildi" +
                "isimler sırayla girildi" +
                "Telefon numarası girildi"+
                "Email adresi girildi " +
                "Kullanıcı mesaji oluşturuldu"
        );

        Thread.sleep(2000);

        String expectedYazi=ConfigReader.getProperty("CHRezervasyonOnayYazisi");
        extentTest.info("Rezervasyon onaylandı ");
        String actualYazi=qaConcortPage.pBasariliYazisiElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi,ConfigReader.getProperty("Rezervasyon yapilamamistir!"));

        Driver.closeDriver();
    }
}
