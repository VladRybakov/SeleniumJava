package org.leagueofbets.page;

import io.qameta.allure.Step;
import org.leagueofbets.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertTrue;

public class YandexPageThird extends BaseTest {

    public WebDriver driver;

    public YandexPageThird(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[4]/div/div/fieldset/ul/li[4]/div/a/label/div")
    private WebElement LG;

    @FindBy(xpath = "//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[4]/div/div/fieldset/ul/li[7]/div/a/label/div")
    private WebElement samsung;

    @FindBy(xpath = "//*[@id=\"glpricefrom\"]")
    private WebElement price;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[3]/div[5]/div/div[1]/div/div/div/article[1]/div[4]/div[1]/h3/a")
    private WebElement tvcard;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[3]/div[5]/div/div[1]/div/div/div/article[1]/div[5]/div[1]/div[1]/a/div/span/span[1]")
    private WebElement checkPrice;

    @Step("We select in the search conditions LG")
    public void clickOnLG() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", LG);
        LG.click();
        saveAllureScreenshot();
    }

    @Step("We select in the search terms Samsung")
    public void clickOnSamsung() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", samsung);
        samsung.click();
        saveAllureScreenshot();
    }

    @Step("Enter the amount from 20000")
    public void enterPrice() throws InterruptedException, AWTException { ;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", price);
        price.click();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_2);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_0);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_0);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_0);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_0);

        saveAllureScreenshot();
    }

    @Step("We check that the price meets the conditions of the request")
    public void checkPrice() {
        String str2 = checkPrice.getText();
        String newStr = str2.replace(" ", "");
        int priceInFilter = 20000;
        try {
            int actualPrice = Integer.parseInt(newStr);
            assertTrue(actualPrice >= priceInFilter);
        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }
        saveAllureScreenshot();
    }

    @Step("Opening the TV card")
    public void clickOnTvCard() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tvcard);
        saveAllureScreenshot();
        tvcard.click();

    }
}
