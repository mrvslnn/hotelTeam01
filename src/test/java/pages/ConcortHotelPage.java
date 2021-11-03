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

}
