package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class DebitBasePage extends BasePage {

    @FindBy(xpath = "//input[@class ='d-f-input handleEnter']")
    WebElement sumInput;


    //Choice of currency

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='14']")
    WebElement  bynCurrency;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='15']")
    WebElement usdCurency;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='16']")
    WebElement eurCurency;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='17']")
    WebElement rubCurency;


    //Choice of term

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='-2']")
    WebElement allDebitTerms;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='0']")
    WebElement oneMonthDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='1']")
    WebElement threeMonthsDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='2']")
    WebElement sixMonthsDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='3']")
    WebElement oneYearDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='4']")
    WebElement twoYearsDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='5']")
    WebElement threeYearsDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='6']")
    WebElement fourYearsDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='7']")
    WebElement fiveYearsDebitTerm;

    @FindBy(xpath = "//select[@class ='d-f-input']/option[@value='8']")
    WebElement moreThanFiveYearsDebitTerm;


    //Checkbox options

    @FindBy(id = "chbTermLess")
    WebElement termLessOptionCheckBox;

    @FindBy(id = "chbTermMore")
    WebElement termMoreOptionCheckBox;

    @FindBy(id = "chbAddOptionFixed")
    WebElement fixedOptionCheckBox;

    @FindBy(id = "chbAddOptionRevocable")
    WebElement revocableOptionCheckBox;

    @FindBy(id = "chbAddOptionIrrevocable")
    WebElement irrevocableOptionCheckBox;

    @FindBy(id = "chbAddOptionWithOutTax")
    WebElement withOutTaxOptionCheckBox;

    @FindBy(id = "chbAddOptionMonthly")
    WebElement monthlyOptionCheckBox;

    @FindBy(id = "chbAddOptionRemote")
    WebElement remoteOptionCheckBox;

    @FindBy(id = "chbAddOptionCapitalization")
    WebElement capitalizationOptionCheckBox;

    @FindBy(id = "chbAddOptionWithCard")
    WebElement withCardOptionCheckBox;

    @FindBy(id = "chbAddOptionPartialWithdrawal")
    WebElement partialWithdrawalOptionCheckBox;


    //Button "Search"

    @FindBy(id = "btnSearch")
    WebElement searchButton;

}
