package com.uhaul.test.day_01.playwright_intro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class PlayWrightTest {
    public static void main(String[] args) throws InterruptedException {

        LocalDate today = LocalDate.now();

        Playwright playwright = Playwright.create();
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false)); // if you want to see browser - pass this in brackets.
        Page page = browser.newPage();

       page.navigate("https://google.com");
       page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshot_"+ today +".png"))); // Screenshot
       Thread.sleep(3000);

       page.close();
       browser.close();
       playwright.close();

    }
}
