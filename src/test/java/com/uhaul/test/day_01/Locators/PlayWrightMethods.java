package com.uhaul.test.day_01.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class PlayWrightMethods {

    @Test
    void test(){
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser - pass in this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://library2.cybertekschool.com/login.html");
        page.getByPlaceholder("Email address",new Page.GetByPlaceholderOptions()
                .setExact(true)).fill("kjhkjkhj@gmail.com");



        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();


    }

}
