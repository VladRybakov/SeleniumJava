package org.leagueofbets.page;

import io.qameta.allure.Step;
import org.leagueofbets.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPageOne extends BaseTest {
    public WebDriver driver;

    public YandexPageOne(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[3]/div[4]/noindex/div/div/div/div[2]/div/div[1]/div[5]") //{"id":"91542578"}
    private WebElement elektronika;

    @Step("Open the Electronics tab")
    public void clickOnElektronika() {
        elektronika.click();
        saveAllureScreenshot();
    }
}
