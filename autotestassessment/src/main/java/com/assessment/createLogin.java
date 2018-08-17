package com.assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class createLogin {
    @FindBy(id = "username")
    private WebElement un;
    @FindBy(id = "password")
    private WebElement pw;
    @FindBy(id = "confirmPassword")
    private WebElement cpw;
    @FindBy(xpath = "//*[@id=\"adminRoleId_inputfileddiv\"]/div")
    private WebElement adminRole;
    @FindBy(id = "systemUserSaveBtn")
    private WebElement save;
    private Actions action;
    createLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public void enterDetails(){
        un.sendKeys("dmann9607" +  Math.floor(Math.random() * 101));
        pw.sendKeys(constant.password);
        cpw.sendKeys(constant.password);
        adminRole.click();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
    public void pressSave(){
        save.click();
    }
}
