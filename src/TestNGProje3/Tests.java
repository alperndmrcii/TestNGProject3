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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tests extends BaseDriver {
    String randomMail = RandomString.make(8);


    @Test(priority = 1)
    void Test1() {


        Locatorlar elements = new Locatorlar();
        elements.register.click();
        elements.firstName.sendKeys("Alperen");
        elements.lastName.sendKeys("Demirci");
        Select birthDay = new Select(elements.birthday);
        birthDay.selectByVisibleText("25");
        Select birthMonth = new Select(elements.birthMonth);
        birthMonth.selectByVisibleText("July");
        Select birthYear = new Select(elements.birthYear);
        birthYear.selectByVisibleText("1975");
        elements.eMail.sendKeys(randomMail + "@gmail.com");
        elements.password.sendKeys("asdasdasd");
        elements.confirmPassword.sendKeys("asdasdasd");
        elements.registerBtn.click();

        Assert.assertTrue(elements.registerComplete.getText().contains("Your registration completed"), "Başarısız Kullanıcı Kaydı");

    }

    @Test(priority = 2)
    void Test2() {
        Locatorlar elements = new Locatorlar();
        elements.logInBtn.click();
        elements.eMail.sendKeys(randomMail + "@gmail.com");
        elements.password.sendKeys("asdasdasd");
        elements.sonLogInButton.click();

        Assert.assertTrue(elements.logOutBtn.getText().toLowerCase().contains("log out"), "Log in olunamadı");
        elements.logOutBtn.click();

    }

    @Test(priority = 3, dataProvider = "datalarim")
    void Test3(String mail, String password) {
        Locatorlar elements = new Locatorlar();
        // wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/"));
        elements.logInBtn.click();
        elements.eMail.sendKeys(mail);
        elements.password.sendKeys(password);
        elements.sonLogInButton.click();
        // SoftAssert _softAssert = new SoftAssert();
        //oftAssert.assertFalse(elements.loginFailMessage.getText().toLowerCase().contains("fail"), "login olundu");
        //Assert.assertFalse(elements.loginFailMessage.getText().toLowerCase().contains("fail"), "log in olundu");


        for (WebElement e : elements.loginFailMessage) {
            if (e.getText().contains("unsuccessful")) {
                Assert.assertTrue(e.getText().toLowerCase().contains("unsuccessful"));
                elements.eMail.clear();
            } else
                Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));

        }

    }


    @DataProvider //
    public Object[][] datalarim() {

        Object[][] data = {
                {"alperendemirci@gmail.com", "elements.password"},
                {"alperen1@gmail.com", "asdasdasd"}};

        return data;
    }

    @Test
    void Test4() {
        Locatorlar elements = new Locatorlar();

        List<String> tabMenuIsimler = new ArrayList<>(Arrays.asList("Computers, Electronics, Apparel, Digital downloads, Books, Jewelry, Gift Cards"));
        for (int i = 0; i < tabMenuIsimler.size(); i++) {
            Assert.assertTrue(tabMenuIsimler.get(i).contains(elements.tabMenu.get(i).getText()));
        }
    }
}
