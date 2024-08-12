package com.uhaul.test.day_01.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleSearch {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser - pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://google.com");

        page.locator("textarea[name='q']").type("Selenium");
        page.keyboard().press("Enter");
        page.waitForTimeout(3000);

        System.out.println(page.title());
        Assertions.assertEquals("Selenium - Google Search",page.title());



        page.close();
        browser.close();
        playwright.close();

    }
}
