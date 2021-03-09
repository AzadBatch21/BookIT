package com.bookit.step_definitions;

import com.bookit.pages.LoginPage;
import com.bookit.utilities.BrowserUtils;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import org.openqa.selenium.remote.BrowserType;

import javax.security.auth.login.LoginContext;

public class Test {

    public static void main(String[] args) {

        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.wait(2);
        loginPage.login("ftabrett8z@latimes.com", "beveriestouther");

    }

}
