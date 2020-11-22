package org.leagueofbets;

import io.qameta.allure.Attachment;;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.leagueofbets.page.YandexPageFourth;
import org.leagueofbets.page.YandexPageOne;
import org.leagueofbets.page.YandexPageSecond;
import org.leagueofbets.page.YandexPageThird;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static YandexPageOne onePage;
    public static YandexPageSecond secondPage;
    public static YandexPageThird thirdPage;
    public static YandexPageFourth fourthPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");

        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        onePage = new YandexPageOne(driver);
        secondPage = new YandexPageSecond(driver);
        thirdPage = new YandexPageThird(driver);
        fourthPage = new YandexPageFourth(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("yandexmarket"));
    }

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    };

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterClass
    public static void tearDown() {
       // driver.quit();
    }
}
