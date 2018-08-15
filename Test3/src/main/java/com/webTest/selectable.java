package com.webTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class selectable {
    @FindBy(className = "ui-selectee") private List<WebElement> Selectees;
    private Actions action;
    private WebDriver driverW;
    selectable(WebDriver driver){
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
        driverW = driver;
    }
    public boolean df1(int... which){
        WebElement[] selected = new WebElement[which.length];
        action.keyDown(Keys.CONTROL);
        for(int i=0;i<which.length;i++){
            action.moveToElement(Selectees.get(which[i])).click().perform();
            selected[i] = Selectees.get(which[i]);
        }
        List<WebElement> cssList = driverW.findElements(By.className("ui-selected"));
        return cssList.size() == selected.length;
        /*int x=0;
        while(x<selected.length){
            if(selected[x].getCssValue("background-color").equals("rgb(243, 152, 20)")){
                x++;
            }
            else{
                return false;
            }
        }
        return true;*/
    }
}
