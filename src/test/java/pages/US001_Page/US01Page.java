package pages.US001_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US01Page {
    public WebDriver driver;
    public US01Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath="//li[@id='navLogon']")
    public WebElement login;
    @FindBy(id="UserName")
    public WebElement username;
    @FindBy(id="Password")
    public WebElement password;
    @FindBy(id="btnSubmit")
    public WebElement submit;
    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement başarılı;
    @FindBy(xpath="//span[text()='Try again please']")
    public WebElement tryAgain;
    @FindBy(xpath = "//div[@class='collapse navbar-collapse']")
    public WebElement navbarMenusu;


}






