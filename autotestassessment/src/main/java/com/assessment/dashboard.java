package com.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class dashboard {
    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
    private WebElement PIM;
    @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    private WebElement addEmployee;
    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement viewList;
    private WebDriver thisDriver;
    dashboard(WebDriver driver){
        PageFactory.initElements(driver, this);
        thisDriver = driver;
    }
    public void clickPIM(){
        PIM.click();
    }
    public void clickEmployee(){
        WebDriverWait wait = new WebDriverWait(thisDriver,5);
        wait.until(ExpectedConditions.visibilityOf(addEmployee));
        addEmployee.click();
    }
    public boolean checkURL(){
        return thisDriver.getCurrentUrl().equals(constant.URL2 + "pim/employees");
    }
}
