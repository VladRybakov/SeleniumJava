package org.leagueofbets.page;

import io.qameta.allure.Step;
import org.leagueofbets.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPageSecond extends BaseTest {

    public WebDriver driver;

    public YandexPageSecond(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[2]/div[5]/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div[5]/div[2]/ul/li[1]/div")
    private WebElement televisors;

    @Step("Open the TVs tab")
    public void clickOnTelevisors() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", televisors);
        televisors.click();
        saveAllureScreenshot();
    }
}
