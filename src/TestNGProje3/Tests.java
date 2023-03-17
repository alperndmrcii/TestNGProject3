package TestNGProje3;

import Utility.BaseDriver;
import Utility.Tools;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.Random;

public class Tests extends BaseDriver {
    String randomMail = RandomString.make(8);


    @Test(priority = 1)
    void Test1() {


        Locatorlar elements = new Locatorlar();
        elements.register.click();
        elements.firstName.sendKeys("Alperen");
        elements.lastName.sendKeys("Demirci");
        Select birthDay=new Select(elements.birthday);
        birthDay.selectByVisibleText("25");
        Select birthMonth=new Select(elements.birthMonth);
        birthMonth.selectByVisibleText("July");
        Select birthYear=new Select(elements.birthYear);
        birthYear.selectByVisibleText("1975");
        elements.eMail.sendKeys(randomMail+"@gmail.com");
        elements.password.sendKeys("asdasdasd");
        elements.confirmPassword.sendKeys("asdasdasd");
        elements.registerBtn.click();

        Assert.assertTrue(elements.registerComplete.getText().contains("Your registration completed"),"Başarısız Kullanıcı Kaydı");

    }

    @Test(priority = 2)
    void Test2() {
        Locatorlar elements = new Locatorlar();
        elements.logInBtn.click();
        elements.eMail.sendKeys(randomMail + "@gmail.com");
        elements.password.sendKeys("asdasdasd");
        elements.sonLogInButton.click();

        Assert.assertTrue(elements.logOutBtn.getText().toLowerCase().contains("log out"),"Log in olunamadı");
    }
}
