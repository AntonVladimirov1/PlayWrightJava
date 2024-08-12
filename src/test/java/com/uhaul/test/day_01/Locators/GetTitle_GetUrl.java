package com.uhaul.test.day_01.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetTitle_GetUrl {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser - pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com");

        System.out.println(page.url());
        Assertions.assertTrue(page.url().contains("cydeo"));

        System.out.println(page.title());
        Assertions.assertEquals("Practice",page.title());

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
