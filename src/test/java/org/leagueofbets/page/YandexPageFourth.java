package org.leagueofbets.page;

import org.leagueofbets.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class YandexPageFourth extends BaseTest {
    public WebDriver driver;

    public YandexPageFourth(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath ="/html/body/div[2]/div[5]/div/div[6]/div/div[1]/div[1]/div[2]/div/div[4]/a/span")
    private WebElement manufacturer;

    public void checkManufacturer() {
        if (manufacturer.getText().contains("LG")){
            assertTrue(manufacturer.getText().contains("LG"));
        }else{
            assertTrue(manufacturer.getText().contains("Samsung"));
        }
    }

}