package com.uhaul.test.day_01.Locators;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleSearch {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser - pass in this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://google.com");

        Locator searchBox=page.locator("textarea[name='q']");
                //searchBox.fill("Selenium"); // can type anything to find
                searchBox.pressSequentially("Selenium",new Locator.PressSequentiallyOptions()
                        .setDelay(100));//if you want to replicate real typing (slowly)
        Keyboard keyboard = page.keyboard();
                 keyboard.press("Enter");

        page.waitForTimeout(3000);

        System.out.println(page.title());
        Assertions.assertEquals("Selenium - Google Search",page.title());



        page.close();
        browser.close();
        playwright.close();


    }
}
