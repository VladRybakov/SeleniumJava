package org.leagueofbets;

import org.junit.Test;

import java.awt.*;

public class YandexTest extends BaseTest {

    @Test
    public void YandexTvTest() throws InterruptedException, AWTException {

        onePage.clickOnElektronika();
        secondPage.clickOnTelevisors();
        thirdPage.clickOnSamsung();
        thirdPage.clickOnLG();
        thirdPage.enterPrice();
        thirdPage.checkPrice();
        thirdPage.clickOnTvCard();
        fourthPage.checkManufacturer();
    }

}
