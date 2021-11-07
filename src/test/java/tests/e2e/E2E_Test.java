package Tests.e2e;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US001_Page.US01Page;
import pages.US002_Page.ConcortHotelPage;
import pages.US003_Page.QAConcortPage;
import pages.US004_Page.US004_pages;
import pages.US008_Page.US_008_QAConcortHotelPage;
import pages.US010_Page.US_0010_ConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReports;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class E2E_Test extends TestBaseReports {

    @Test
    public void test1() {

        extentTest=extentReports.createTest("Login butonu testi", "Valid degerler girildiginde login olunabildigi test edildi");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        extentTest.pass("Concort Hotel sitesine gidildi");
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        US01Page loginPage = new US01Page();
        loginPage.login.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        loginPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        extentTest.pass("Valid degerler girildi");
        loginPage.submit.click();
        extentTest.pass("Basarili login islemi test edildi");
        System.out.println(loginPage.başarılı.getText());
    }

    @Test
    public void test2() {
        extentTest=extentReports.createTest("Login butonu Negative test", "Hatali data girildiginde login olunamadigi test edildi");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        extentTest.pass("Concort Hotel sitesine gidildi");
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ConcortHotelPage concorthotel = new ConcortHotelPage();
        concorthotel.login.click();
        concorthotel.username.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        extentTest.pass("Invalid kullanici adi girildi");
        concorthotel.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        concorthotel.submit.click();
        extentTest.pass("Invalit data kullanildiginda login olunamadigi goruldu");

    }

    @Test
    public void test3() throws InterruptedException {
        extentTest=extentReports.createTest("Links Testi", "Linklerin Calisiyor oldugu test edildi");

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.concortHotelLogin();
        Thread.sleep(2000);
        qaConcortPage.buttonsClick();
        extentTest.pass("Hotel Management Linki Calisiyor");
        extentTest.pass("Hotel List Linki Calisiyor");
        extentTest.pass("ADD Hotel Linki Calisiyor");

    }

    @Test
    public void test4() throws InterruptedException {
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

    @Test
    public void test5() throws InterruptedException {

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

    @Test
    public void Test6() throws InterruptedException {

        extentTest=extentReports.createTest("Oda Rezervasyon Testi","Valid Data girildiginde oda rezervasyonu yapilabildigi test edilir");
        Driver.getDriver().get(ConfigReader.getProperty("PCHUrl"));

        US_008_QAConcortHotelPage qaConcortPage= new US_008_QAConcortHotelPage();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        qaConcortPage.pLoginTusu.click();
        extentTest.pass("Login islemi yapildi");

        Select selectUser=new Select(qaConcortPage.pSelectUser);
        selectUser.selectByValue(ConfigReader.getProperty("CHUserId"));
        extentTest.pass("Kullaci girisi yapildi");

        Select selectHotelRoom =new Select(qaConcortPage.pSelectHotelRoom);
        selectHotelRoom.selectByValue(ConfigReader.getProperty("CHHotelSecim"));
        extentTest.pass("Drop down kullanilarak otel secildi");

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

        extentTest.pass("Faker kullanilarak form dolduruldu");

        qaConcortPage.pSave.click();

        Thread.sleep(2000);

        String expectedYazi=ConfigReader.getProperty("CHRezervasyonOnayYazisi");
        String actualYazi=qaConcortPage.pBasariliYazisiElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi,ConfigReader.getProperty("Rezervasyon yapilamamistir!"));
        extentTest.pass("Oda rezervasyonu yapilabildigi test edildi");

        Driver.closeDriver();
    }

    @Test
    public void test7() throws InterruptedException {

        extentTest=extentReports.createTest("List of Hotel Room Testi 1","List of Hotel Room linki ve devaminin calisiyor oldugu test edilir");
        Driver.getDriver().get(ConfigReader.getProperty("ProjeCHQAUrl"));
        US_0010_ConcortHotelPage concortHotelPage=new US_0010_ConcortHotelPage();
        concortHotelPage.LoginLinki.click();
        extentTest.pass("Login olundu");
        concortHotelPage.usernameBox.sendKeys(ConfigReader.getProperty("ProjeCHUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("ProjeCHPassword"));
        concortHotelPage.LoginButonu.click();
        concortHotelPage.hotelManagementButonu.click();
        concortHotelPage.HotelRoomsButonu.click();
        extentTest.pass("Hotel Room butonuna click yapildi");
        Assert.assertTrue (concortHotelPage.ListOfHotelRoomsYazisi.isDisplayed());
        extentTest.pass("List Hotel Room yazisi goruldu");
        Driver.closeDriver();
    }

    @Test
    public void test8() throws InterruptedException {

        extentTest=extentReports.createTest("List of Hotel Room Testi 2","Oda seciminin yapilabildigi, clear butonunun calisiyor  oldugu test edilir");
        Driver.getDriver().get(ConfigReader.getProperty("ProjeCHQAUrl"));
        US_0010_ConcortHotelPage concortHotelPage = new US_0010_ConcortHotelPage();
        concortHotelPage.LoginLinki.click();
        extentTest.pass("Login olundu");
        concortHotelPage.usernameBox.sendKeys(ConfigReader.getProperty("ProjeCHUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("ProjeCHPassword"));
        concortHotelPage.LoginButonu.click();
        concortHotelPage.hotelManagementButonu.click();
        concortHotelPage.HotelRoomsButonu.click();
        extentTest.pass("Hotel Room butonuna click yapildi");
        Select select = new Select(concortHotelPage.IDHotelDropDownu);
        select.selectByVisibleText("Yeni Hotel");
        System.out.println(select.getFirstSelectedOption());
        concortHotelPage.ListofHotelRoomsSearchButonu.click();
        extentTest.pass("List of Hotel Rooms Search Butonu click yapildi");
        Thread.sleep(2000);
        concortHotelPage.ListofHotelRoomsClearButonu.click();
        extentTest.pass("List of Hotel Rooms Clear Butonu click yapildi");

    }

    @Test
    public void test9() throws InterruptedException {

        extentTest=extentReports.createTest("Ikinci web sayfasina gecis Testi","Hotel List Linki, Details Butonu ve devami unsurlarin calisiyor oldugu gorulmeli");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        US004_pages us004Pages = new US004_pages();
        us004Pages.ilkLoginLinki.click();
        us004Pages.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        us004Pages.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        us004Pages.loginButonu.click();
        extentTest.pass("Login olundu");
        us004Pages.hotelManagementLinki.click();
        extentTest.pass(" hotel Management Linkine click yapildi");
        us004Pages.hotelListLink.click();
        extentTest.pass(" hotel List Linkine click yapildi");
        us004Pages.detailsButonu.click();
        extentTest.pass(" details buttonuna click yapildi");
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
        extentTest.pass(" ikinci web sayfasina gecis yapildi");

        us004Pages.addHotelCodeKutusu.clear();
        us004Pages.addHotelCodeKutusu.sendKeys("1234"+ Keys.ENTER);
        extentTest.pass(" add Hotel code yeni data girildi");

        us004Pages.okButonu.click();
        extentTest.pass(" Ok buttonuna click yapildi");
        Driver.closeDriver();

    }
    @Test
    public void test10() throws InterruptedException {
        extentTest=extentReports.createTest("Yeni Otel kaydi Negative Test","Hotel List Linki, Details Butonu ve devami unsurlarin calisiyor oldugu gorulmeli");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        US004_pages us004Pages = new US004_pages();

        us004Pages.ilkLoginLinki.click();
        us004Pages.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        us004Pages.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        us004Pages.loginButonu.click();
        extentTest.pass(" Login olundu ");
        us004Pages.hotelManagementLinki.click();
        extentTest.pass("hotel Management Linkine click yapildi");
        us004Pages.hotelListLink.click();
        extentTest.pass("hotel List Linkine click yapildi");
        us004Pages.detailsButonu.click();
        Thread.sleep(2000);

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
        extentTest.pass("Ikinci web sayfasina gecildi");
        us004Pages.adresButonu.clear();
        extentTest.pass("Adress box clear ile silindi");
        us004Pages.adresButonu.sendKeys(ConfigReader.getProperty("adres")+Keys.ENTER);
        extentTest.pass("yeni adres datasi girildi");

        Select select = new Select(us004Pages.idGroupHotelEkle);
        select.selectByVisibleText("Hotel Type2");

        Thread.sleep(3000);

        String addHotelExpectedAlertYazisi = "Hotel was inserted successfully";
        String addHotelActualAlertYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).getText();

        Assert.assertFalse(addHotelActualAlertYazisi.equals(addHotelExpectedAlertYazisi) , "Hotel kaydi yapilamamistir");
        extentTest.pass("Hotel was inserted successfully yazisinin goruldugu test edildi");

        us004Pages.okButonu.click();

        Driver.closeDriver();
    }

    pages.US006_Page.QAConcortPage qaConcortPage;

    @Test
    public void test11() {
        extentTest=extentReports.createTest("Hotel Rooms Boxs Search-Clear Buttonlarinin Testi","Code, Name, adress gibi text boxs lara data girildiginde searc butonu ile arama ypailabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        qaConcortPage =new pages.US006_Page.QAConcortPage();
        qaConcortPage.login.click();
        qaConcortPage.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
        extentTest.pass("Login olundu");
        qaConcortPage.hotelManagement.click();
        extentTest.pass("Hotel Management linkine click yapildi");
        qaConcortPage.hotelRooms.click();
        extentTest.pass("Hotel Rooms linkine click yapildi");
        qaConcortPage.roomId.sendKeys("15");
        extentTest.pass("code box data girildi");
        qaConcortPage.roomSearch.click();
        extentTest.pass("search ile arama yapildi");
        Driver.closeDriver();
    }

}
