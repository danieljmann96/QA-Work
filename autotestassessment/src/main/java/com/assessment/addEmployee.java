package com.assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class addEmployee {
    @FindBy(id = "firstName")
    private WebElement fn;
    @FindBy(id = "lastName")
    private WebElement ln;
    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div")
    private WebElement location;
    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement loginD;
    private WebDriver thisDriver;
    private Actions action;
    addEmployee(WebDriver driver){
        PageFactory.initElements(driver, this);
        thisDriver = driver;
        action = new Actions(driver);
    }
    public void enterDetails(){
        WebDriverWait wait = new WebDriverWait(thisDriver,40);
        wait.until(ExpectedConditions.visibilityOf(ln));
        fn.sendKeys("Daniel");
        ln.sendKeys("Mann");
        location.click();
        for(int i=1;i<=3;i++) action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
    }
    public void selectLogin(){
        loginD.click();
    }
}
