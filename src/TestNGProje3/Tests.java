package TestNGProje3;

import Utility.BaseDriver;
import org.testng.annotations.Test;

public class Tests extends BaseDriver {

    @Test
    void Test1() {
        Locatorlar elements = new Locatorlar();

        elements.register.click();
        elements.firstName.sendKeys("İsmet");
        elements.lastName.sendKeys("Temur");
    }
}