package com.webTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class draggable {
    @FindBy(id = "draggable") private WebElement defaultF;
    private Actions action;
    draggable(WebDriver driver){
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean defaultFunctionality(int a, int b){
        Point original = defaultF.getLocation();
        action.dragAndDropBy(defaultF, a, b).perform();
        Point newL = defaultF.getLocation();
        return original.getX() != newL.getX() || original.getY() != newL.getY();
    }
}
