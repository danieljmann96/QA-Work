package com.webTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class droppable {
    @FindBy(id = "draggableview") private WebElement defaultF;
    @FindBy(id = "droppableview") private WebElement defaultFD;
    @FindBy(xpath = "//*[@id=\"droppableview\"]/p") private WebElement defaultFDT;
    private Actions action;
    droppable(WebDriver driver){
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean defaultFunctionality(){
        action.dragAndDrop(defaultF, defaultFD).perform();
        return defaultFDT.getText().equals("Dropped!");
    }
}
