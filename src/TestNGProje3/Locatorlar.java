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


}
