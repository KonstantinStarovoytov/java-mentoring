package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfobankMainPage extends BasePage {

    @FindBy(xpath = "//a[@href='/potrebiteljskie-kredity/']")
    WebElement consumerCreditsPage;

    public void goToMainPage(String url){
        driver.get(url);
    }



}
