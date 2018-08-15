package com.webTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class resizable {
    @FindBy(xpath = "//*[@id=\"resizable\"]/div[3]") private WebElement handle;
    private Actions action;
    resizable(WebDriver driver){
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean defaultFunctionality(int a, int b){
        Point original = handle.getLocation();
        action.dragAndDropBy(handle, a, b).perform();
        Point newL = handle.getLocation();
        return original.getX() != newL.getX() || original.getY() != newL.getY();

    }
}
