package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {
    WebDriver driver ;
    public  ConcortHotelPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement login;

    @FindBy(id="UserName")
    public WebElement username;


    @FindBy(id="Password")
    public WebElement password;


    @FindBy(id="btnSubmit")
    public WebElement submit;




    @FindBy(xpath="//span[text()='Try again please']")
    public WebElement tryAgain;

    //## ilker  ##

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

    public ConcortHotelPage() {

    }


    //  #### ilker    #####



}
