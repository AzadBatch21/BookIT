package com.bookit.pages;

import com.bookit.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@name='password']")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void login(String userName, String passWord) {
        emailInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(passWord);
        submitButton.click();
    }


}
