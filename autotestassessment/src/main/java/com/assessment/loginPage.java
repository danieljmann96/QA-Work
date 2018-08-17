package com.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    @FindBy(id = "txtUsername") private WebElement username;
    @FindBy(id = "txtPassword") private WebElement password;
    @FindBy(id = "btnLogin") private WebElement submit;
    private WebDriver thisDriver;
    loginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        thisDriver = driver;
    }
    public void loginTask(){
        username.sendKeys("Admin");
        password.sendKeys("AdminAdmin");
        submit.click();
    }
    public boolean checkURL(){
        return thisDriver.getCurrentUrl().equals(constant.URL2 + "dashboard");
    }
}
