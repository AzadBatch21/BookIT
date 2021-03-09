package com.bookit.pages;

import com.bookit.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="room-121")
    public WebElement kilimanjaroLink;

    @FindBy(id="room-122")
    public WebElement halfDomeLink;

    @FindBy(id="room-123")
    public WebElement denaliLink;

    @FindBy(id="room-124")
    public WebElement meruLink;

    @FindBy(xpath = "(//*[.=‘hunt’])[1]")
    public WebElement huntLink;

    @FindBy(xpath = "(//*[.=‘map’])[1]")
    public WebElement mapLink;


}
