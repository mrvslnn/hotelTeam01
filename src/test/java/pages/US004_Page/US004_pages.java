package pages.US004_Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US004_pages {
    public US004_pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//li[@id='navLogon']")
    public WebElement ilkLoginLinki;

    @FindBy(id="UserName")
    public WebElement usernameKutusu;

    @FindBy(id="Password")
    public WebElement passwordKutusu;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;


    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;


    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;



    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement idGroupHotelEkle;



    @FindBy (xpath ="//button[@class='btn btn-primary']")
    public WebElement okButonu;

    @FindBy(xpath = "//a[@class='btn btn-xs default']")
    public WebElement detailsButonu;

    @FindBy(xpath ="//input[@id='Name']")
    public WebElement nameButonu;

    @FindBy(xpath="//input[@id='Address']")
    public WebElement adresButonu;

    @FindBy(xpath="//input[@id='Phone']")
    public WebElement phoneButonu;

    @FindBy(xpath = "//input[@name='Code']")
    public WebElement addHotelCodeKutusu;

    @FindBy(xpath = "((//button[@class='btn green'])[1]")
    public WebElement saveButonu;


@FindBy(xpath = "//input[@id='Email']")
public WebElement mailButonu;

}
