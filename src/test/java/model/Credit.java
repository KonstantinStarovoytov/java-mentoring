package model;

public class Credit {

    private String bankName;
    private String minimalTerm;
    private String baseSum;
    private String overpayAmount;
    private String overpayPercent;
    private String effectiveOverpayPercent;

    public Credit(String bankName, String minimalTerm, String baseSum, String overpayAmount, String overpayPercent, String effectiveOverpayPercent) {
        this.bankName = bankName;
        this.minimalTerm = minimalTerm;
        this.baseSum = baseSum;
        this.overpayAmount = overpayAmount;
        this.overpayPercent = overpayPercent;
        this.effectiveOverpayPercent = effectiveOverpayPercent;
    }

    public String getBankName() {
        return bankName;
    }

    public String getMinimalTerm() {
        return minimalTerm;
    }

    public String getBaseSum() {
        return baseSum;
    }

    public String getOverpayAmount() {
        return overpayAmount;
    }

    public String getOverpayPercent() {
        return overpayPercent;
    }

    public String getEffectiveOverpayPercent() {
        return effectiveOverpayPercent;
    }

}
