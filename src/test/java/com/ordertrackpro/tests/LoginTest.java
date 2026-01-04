package com.ordertrackpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed");
    }


    @Test
    public void testInvalidLogin() {
        loginPage.login("wrong", "wrong");
        Assert.assertTrue(
                loginPage.isInvalidLoginMessageDisplayed(),
                "Invalid login message not displayed"
        );
    }

}
