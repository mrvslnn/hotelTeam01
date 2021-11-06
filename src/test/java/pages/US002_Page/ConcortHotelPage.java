package pages.US002_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ConcortHotelPage {
    public WebDriver driver;
    public ConcortHotelPage() {
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




}