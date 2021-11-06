package pages.US007_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_007_Pages {
    public WebDriver driver;

    public US_007_Pages () {
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
    @FindBy(xpath="//span[text()='Hotel Management']")
    public WebElement management;
    @FindBy (partialLinkText = "Room reservations")
    public  WebElement roomReservation;
    @FindBy(xpath = "//span[text()='Add Room Reservation ']")
    public WebElement addRoomReservation;

    //TC_002
    @FindBy(xpath = "//select[@name='IDUser']")
    public WebElement selectUser;
    @FindBy(xpath = "//select[@name='IDHotelRoom']")
    public WebElement selectId;

    //TC_003
    @FindBy(xpath = "//Input[@name='Price']")
    public WebElement Price;
    @FindBy(xpath = "//Input[@name='DateStart']")
    public WebElement DateStart;
    @FindBy(xpath = "//Input[@name='DateEnd']")
    public WebElement DateEnd;
    @FindBy(xpath = "//Input[@name='AdultAmount']")
    public WebElement AdultAmount;
    @FindBy(xpath = "//Input[@name='ChildrenAmount']")
    public WebElement ChildrenAmount;
    @FindBy(xpath = "//Input[@name='ContactNameSurname']")
    public WebElement ContactNameSurname;
    @FindBy(xpath = "//Input[@name='ContactPhone']")
    public WebElement ContactPhone;
    @FindBy(xpath = "//Input[@name='ContactEmail']")
    public WebElement ContactEmail;
    @FindBy(xpath = "//Input[@name='Notes']")
    public WebElement Notes;

    //TC_004
    @FindBy(xpath = "(//input[@name='Approved'])[1]")
    public WebElement Approved;
    @FindBy(xpath = "(//input[@name='IsPaid'])[1]")
    public WebElement IsPaid;


    //TC_005
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement Save;

    @FindBy(xpath = "(//*[.='OK'])[2]")
    public WebElement Ok;





}
