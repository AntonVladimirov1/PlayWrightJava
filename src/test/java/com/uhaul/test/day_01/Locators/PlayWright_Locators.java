package com.uhaul.test.day_01.Locators;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.uhaul.test.Hooks.BaseTestPage;
import org.junit.jupiter.api.Test;

public class PlayWright_Locators extends BaseTestPage {


    @Test
    void test(){

        page.navigate("https://library2.cybertekschool.com/login.html");
        page.getByPlaceholder("Email address",new Page.GetByPlaceholderOptions()
                .setExact(true)).fill("kjhkjkhj@gmail.com");
        //page.getByText("Hello",new Page.GetByTextOptions().setExact(true));
        //page.getByLabel("Password").fill("incorrectPassword");
        //page.querySelector("#ID").fill("incorrectPassword");
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Sign In")).click();
        page.waitForTimeout(3000);

        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());
        System.out.println(page.getByRole(AriaRole.ALERT).textContent());

        page.waitForTimeout(3000);


    }

}
