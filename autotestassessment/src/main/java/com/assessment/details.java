package com.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class details {
    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement viewList;
    @FindBy(xpath = "//*[@id=\"pimPersonalDetailsForm\"]/materializecss-decorator[8]/div/sf-decorator[2]/div/button")
    private WebElement verify;
    private WebDriver thisDriver;
    details(WebDriver driver){
        PageFactory.initElements(driver, this);
        thisDriver = driver;
    }
    public void search(){
        WebDriverWait wait = new WebDriverWait(thisDriver,40);
        wait.until(ExpectedConditions.visibilityOf(verify));
        viewList.click();
    }
}
