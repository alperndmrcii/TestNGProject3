package TestNGProje3;

import Utility.BaseDriver;
import Utility.Tools;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Tests extends BaseDriver {

    @Test
    void Test1() {
        Locatorlar elements = new Locatorlar();

        String randomMail = RandomString.make(8);
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
}