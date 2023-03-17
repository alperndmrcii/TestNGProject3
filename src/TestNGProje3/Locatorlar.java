package TestNGProje3;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locatorlar {

    public Locatorlar() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement register;

    @FindBy(xpath = "//*[@id='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    public WebElement birthday;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement birthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    public WebElement birthYear;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[@id='register-button']")
    public WebElement registerBtn;

    @FindBy(xpath = "//*[text()='Your registration completed']")
    public WebElement registerComplete;

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement logInBtn;

    @FindBy(xpath = "//*[@class='button-1 login-button']")
    public WebElement sonLogInButton;

    @FindBy(xpath = "//*[text()='Log out']")
    public WebElement logOutBtn;

    @FindBy(xpath = "//*[@class='message-error validation-summary-errors']")
    public List<WebElement> loginFailMessage;


    @FindBy(xpath = "//*[@class='top-menu notmobile']/li")
    public List<WebElement> tabMenu;

    @FindBy(xpath = "//*[@class='top-menu notmobile']/li[7]")
    public WebElement gifts;

    @FindBy(xpath = "//*[@id='giftcard_44_RecipientName']")
    public WebElement recipientsName;

    @FindBy(xpath = "//*[@id='giftcard_44_SenderName']")
    public WebElement yourName;

    @FindBy(xpath = "//*[@id='giftcard_44_Message']")
    public WebElement msg;

    @FindBy(xpath = "//*[@class='button-2 product-box-add-to-cart-button']")
    public List<WebElement> physicalGifts;
    @FindBy(xpath = "//*[@class='button-1 add-to-cart-button']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//p[@class='content']")
    public WebElement addToCartMessage;

    @FindBy(xpath = "//*[text()='Computers ']")
    public WebElement computers;

    @FindBy(xpath = "//*[text()='Desktops ']")
    public WebElement desktops;

    @FindBy(xpath = "//*[text()='Build your own computer']")
    public WebElement buildYourOwnComputer;

    @FindBy(xpath = "//*[@id='product_attribute_2']")
    public WebElement rams;

    @FindBy(xpath = "//input[@type='radio' and @name='product_attribute_3']")
    public List<WebElement> hdd;

    @FindBy(xpath = "//*[@id='add-to-cart-button-1']")
    public  WebElement addToCartforDesktops;

    @FindBy(xpath = "//*[@placeholder='Search store']")
    public WebElement search;
    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[text()='Adobe Photoshop CS4']")
    public WebElement photoshopc4;

}
