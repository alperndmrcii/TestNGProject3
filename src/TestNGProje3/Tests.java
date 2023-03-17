package TestNGProje3;

import Utility.BaseDriver;
import Utility.Tools;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
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

    @Test(priority = 4)
    void Test4() {
        Locatorlar elements = new Locatorlar();

        List<String> tabMenuIsimler = new ArrayList<>(Arrays.asList("Computers, Electronics, Apparel, Digital downloads, Books, Jewelry, Gift Cards"));
        for (int i = 0; i < tabMenuIsimler.size(); i++) {
            Assert.assertTrue(tabMenuIsimler.get(i).contains(elements.tabMenu.get(i).getText()));
        }
    }

    @Test(priority = 5)
    void Test5() {

        Locatorlar elements = new Locatorlar();
        elements.gifts.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/gift-cards"));
        int randomtamsayi= ((int) (Math.random()*2))+1;
        elements.physicalGifts.get(randomtamsayi).click();
        wait.until(ExpectedConditions.visibilityOf(elements.recipientsName));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elements.recipientsName);
        elements.recipientsName.sendKeys("Abdul");
        elements.yourName.sendKeys("alperen");
        elements.msg.sendKeys("Güle güle kullan");
        elements.addToCartBtn.click();

        Assert.assertTrue(elements.addToCartMessage.getText().contains("The product has been added to your shopping cart"),"Alışveriş Tamamlanamadı");
    }
    @Test(priority = 6)
    void Test6(){

        Locatorlar elements = new Locatorlar();
        Actions aksiyonlar=new Actions(driver);
        aksiyonlar.moveToElement(elements.computers).build().perform();
        aksiyonlar.moveToElement(elements.desktops).click().build().perform();
        elements.buildYourOwnComputer.click();
        int randomtamsayi= ((int) (Math.random()*3))+1;
        Select randomRam=new Select(elements.rams);
        randomRam.selectByIndex(randomtamsayi);
        int randomtamsayi2= ((int) (Math.random()*2)+1);
        elements.hdd.get(randomtamsayi2).click();
        elements.addToCartforDesktops.click();

        Assert.assertTrue(elements.addToCartMessage.getText().contains("The product has been added to your shopping cart"),"Alışveriş Tamamlanamadı");

    }
    @Test(priority = 7)
    void Test7(){
        Locatorlar elements = new Locatorlar();
        elements.search.sendKeys("Adobe Photoshop CS4");
        elements.searchButton.click();
        Assert.assertTrue(elements.photoshopc4.getText().contains("Adobe Photoshop CS4"),"Ürün Bulunamadı");

    }
}
