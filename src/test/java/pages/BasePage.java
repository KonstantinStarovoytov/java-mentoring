package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.security.AccessControlContext;


public class BasePage {
    private static final int TIMEOUT = 10;
    protected WebDriver driver;


    protected BasePage() {
        driver = BaseDriver.getWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementVisible(WebElement element){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForElementEnabled(WebElement element) {
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
   }

    protected void clearAndSendKeys(String keys, WebElement element){
        element.clear();
        element.sendKeys(keys);
    }
    protected void clickToElement(WebElement element){
        new Actions(driver).click(element).build().perform();
    }




//    protected void waitForElementEnabled(By locator) {
//        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
//    }
//
//    protected void highlightElementByBlue(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='4px solid blue'", element);
//    }
//
//    protected void unHighlightElementByBlue(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
//    }
//
//    protected void highlightElementByYellow(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='4px solid yellow'", element);
//    }
//
//    protected void unHighlightElementByYellow(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
//    }
}