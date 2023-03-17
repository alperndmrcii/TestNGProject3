package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public WebDriver driver; //
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemler(String browserTipi) {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (browserTipi.toLowerCase()) {
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                System.out.println("Firefox Started");
                break;

            case "safari":
                driver = new SafariDriver();
                System.out.println("Safari Started");
                break;

            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
        }


        driver.manage().window().maximize();
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement email = driver.findElement(By.xpath("//*[@name='email']"));
        email.sendKeys("asdasdasd123@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("asdasd123");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@value='Login']"));
        loginBtn.click();

    }

    @AfterClass
    public void bitisIslemleri() {
        System.out.println("bitiş işlemleri yapılıyor");
        Tools.Bekle(3);
        driver.quit();
    }

    public void screenShotAl() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) driver; // 1.aşama ekran görüntü alma değişkenini tanımladım
        File hafizadakiHali = ss.getScreenshotAs(OutputType.FILE); // 2. aşamada ekran görüntüsü alındı şuan hafızada
        // hafızadaki bu bilgiyi dosya olarak kaydetmem gerek
        LocalTime saat = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter tarihVeSaat = DateTimeFormatter.ofPattern("dd_MM_yyyy__kk_mm_");
        FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri\\" + dt.format(tarihVeSaat) + saat.getSecond() + ".png"));
    }
}
