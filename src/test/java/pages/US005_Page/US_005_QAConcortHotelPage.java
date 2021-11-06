package pages.US005_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_005_QAConcortHotelPage {
    public WebDriver driver;

    public US_005_QAConcortHotelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement usernameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelLink;

    @FindBy(id = "Code")
    public WebElement addHotelCodeKutusu;

    @FindBy(id = "IDGroup")
    public WebElement addHotelDropdown;

    @FindBy(id = "btnSubmit")
    public WebElement addHotelSave;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addHotelSuccesfullYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addHotelAllertOk;


    public void ConcortHotelLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        US_005_QAConcortHotelPage US005QaConcortHotelPage = new US_005_QAConcortHotelPage();
        US005QaConcortHotelPage.ilkLoginLinki.click();
        US005QaConcortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        US005QaConcortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        US005QaConcortHotelPage.loginButonu.click();
    }

    public void buttonsClick (){
        US_005_QAConcortHotelPage qaConcortPage=new   US_005_QAConcortHotelPage();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        qaConcortPage.addHotelLink.click();
    }



}
