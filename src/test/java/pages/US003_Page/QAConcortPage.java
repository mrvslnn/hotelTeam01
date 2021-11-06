package pages.US003_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QAConcortPage {

    WebDriver driver;
    public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginButton;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"btnSubmit\"]")
    public WebElement ikinciLoginButton;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement basariligGirisYaziElementi;

    @FindBy(xpath = "//*[@id=\"divMessageResult\"]/div/span")
    public WebElement negativeResultMessage;

    @FindBy(xpath = "//*[@id=\"menuHotels\"]/span[1]")
    public WebElement hotelManagementButton;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListButton;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelButton;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeBox;

    @FindBy (xpath = "//select[@id='IDGroup']")
    public WebElement selectIDGroup;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div")
    public WebElement successfullyTextElement;

    @FindBy (xpath = "/html/body/div[5]/div/div/div[2]/button")
    public WebElement okButton;

    public void concortHotelLogin (){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginButton.click();
        qaConcortPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAValidusername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.ikinciLoginButton.click();

    }

    public void buttonsClick (){
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.hotelManagementButton.click();
        qaConcortPage.hotelListButton.click();
        qaConcortPage.addHotelButton.click();
    }

}
