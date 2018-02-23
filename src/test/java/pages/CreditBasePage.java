package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class CreditBasePage extends BasePage {

    // FOR BUSINESS PAGE
    @FindBy(xpath = "//select[@id='BankCombo']")
    WebElement allBanks;
    @FindBy(xpath = "//select[@id='CurrencyCombo']/option[@value='-2']")
    WebElement allCurrency;
    @FindBy(xpath = "//select[@id='CurrencyCombo']/option[@value='14']")
    WebElement bynCurrency;
    @FindBy(xpath = "//select[@id='CurrencyCombo']/option[@value='15']")
    WebElement usdCurrency;
    @FindBy(xpath = "//select[@id='CurrencyCombo']/option[@value='16']")
    WebElement eurCurrency;
    @FindBy(xpath = "//select[@id='CurrencyCombo']/option[@value='17']")
    WebElement rurCurrency;
    @FindBy(xpath = "//input[@id='SumTextBox']")
    WebElement summation;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='-2']")
    WebElement allTermsForBusiness;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='0']")
    WebElement upToOneYear;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='1']")
    WebElement fromOneYearToThree;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='2']")
    WebElement fromThreeYearsToFive;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='3']")
    WebElement fromFiveYearsAndMore;
    @FindBy(xpath = "//a[@class='btn-search']")
    WebElement buttonSearch;
    @FindBy(xpath = "//input[@id='ZCheck']")
    WebElement checkBoxGuarantyForBusiness;
    //=================================================================

    //CONSUMER CREDIT
//    @FindBy(xpath = "//input[@id='SumTextBox']")
//    common ===> WebElement summation;                           <=== common element
    //terms
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='-2']")
    WebElement allTermsForConsumer;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='0']")
    WebElement threeMonthes;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='1']")
    WebElement sixMonthes;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='2']")
    WebElement oneYear;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='3']")
    WebElement twoYears;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='4']")
    WebElement threeYears;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='5']")
    WebElement fourYears;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='6']")
    WebElement fiveYears;
    @FindBy(xpath = "//select[@id='TermCombo']/option[@value='7']")
    WebElement moreThenFiveYears;



    //conditions
    @FindBy(xpath = "//select[@id='dropIssueTime']/option[@value='1']")
    WebElement allConditionsTakeCreditFor;
    @FindBy(xpath = "//select[@id='dropIssueTime']/option[@value='2']")
    WebElement oneHourCondition;
    @FindBy(xpath = "//select[@id='dropIssueTime']/option[@value='3']")
    WebElement oneDayCondition;
    @FindBy(xpath = "//select[@id='dropIssueTime']/option[@value='4']")
    WebElement threeDaysCondition;
    @FindBy(xpath = "//select[@id='dropIssueTime']/option[@value='5']")
    WebElement forFiveDaysCondition;
    @FindBy(xpath = "//select[@id='dropIssueTime']/option[@value='6']")
    WebElement forTenDaysCondition;
    @FindBy(xpath = "//select[@id='dropIssueTime']/option[@value='7']")
    WebElement moreThenTenDaysCondition;

    //Banks criterion
    @FindBy(xpath = "//select[@id='BankCombo']") //"//select[@id='BankCombo']/option[@value='-2']"
    WebElement getAllBanksCredit;
    @FindBy(xpath = "//a[@id='credit-search']")
    WebElement creditSearchBtn;
    @FindBy(xpath = "//input[@id='chkGuarantyNeed']")
    WebElement guarantyCheckbox;
    @FindBy(xpath = "//input[@id='FGRACEPERIOD']")
    WebElement gracePeriodCheckbox;







    //=================================================================





}
