package com.uhaul.test.day_01.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClickLinkWithText {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser - pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com");
        //page.setViewportSize(1920,1080);

        page.click("text=Autocomplete");
        page.waitForTimeout(2000);
        System.out.println(page.title());

        Assertions.assertTrue(page.title().contains("xxx"));


        page.close();
        browser.close();
        playwright.close();

    }
}
