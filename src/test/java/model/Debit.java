package model;

public class Debit {

    private String bankName;
    private String profitIncomePercent;
    private String term;
    private String profitIncomeAmount;
    private String taxAmount;
    private String additionalFeePossibility;
    private String capitalizePossibility;
    private String partialWithdrawalPossibility;

    public Debit(String bankName, String profitIncomePercent, String term, String profitIncomeAmount, String taxAmount, String additionalFeePossibility, String capitalizePossibility, String partialWithdrawalPossibility) {
        this.bankName = bankName;
        this.profitIncomePercent = profitIncomePercent;
        this.term = term;
        this.profitIncomeAmount = profitIncomeAmount;
        this.taxAmount = taxAmount;
        this.additionalFeePossibility = additionalFeePossibility;
        this.capitalizePossibility = capitalizePossibility;
        this.partialWithdrawalPossibility = partialWithdrawalPossibility;
    }

    public String getBankName() {
        return bankName;
    }

    public String getProfitIncomePercent() {
        return profitIncomePercent;
    }

    public String getTerm() {
        return term;
    }

    public String getProfitIncomeAmount() {
        return profitIncomeAmount;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public String getAdditionalFeePossibility() {
        return additionalFeePossibility;
    }

    public String getCapitalizePossibility() {
        return capitalizePossibility;
    }

    public String getPartialWithdrawalPossibility() {
        return partialWithdrawalPossibility;
    }




}

