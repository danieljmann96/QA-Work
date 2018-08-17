package com.assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class searchPage {
    @FindBy(id = "employee_name_quick_filter_employee_list_value")
    private WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"employeeListTable\"]/tbody/tr[1]/td[1]/img")
    private WebElement verify;
    @FindBy(id = "quick_search_icon")
    private WebElement button;
    @FindBy(xpath = "//*[@id=\"employeeListTable\"]/tbody/tr[1]/td[3]")
    private WebElement text;
    private Actions action;
    private WebDriver thisDriver;
    searchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
        thisDriver = driver;
    }
    public void search() throws Exception{
        WebDriverWait wait = new WebDriverWait(thisDriver,40);
        wait.until(ExpectedConditions.visibilityOf(verify));
        searchBar.sendKeys("Daniel Mann");
        Thread.sleep(2000);
        button.click();
    }
    public boolean checkSearch(){
        return text.getText().contains("Daniel");
    }
}
