package com.sprint3.pages;

import com.sprint3.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    /*@FindBy(xpath = "//input[@id='user']")
    public WebElement username;*/

    @FindBy(id = "user")
    public WebElement inputUsername;

/*    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;*/

    @FindBy(id = "password")
    public WebElement InputPassword;

    @FindBy(id = "submit-form")
    public WebElement loginBtn;

    @FindBy(xpath = "//img[@src='/core/img/actions/toggle.svg']")
    public WebElement eyeIcon;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;




}
