package credits;

import banks.Bank;

public abstract class Credit {
    private Bank bank;
    static private double refinancingRate = .1d;
    private double interestRate;
    private int term;
    private int minValue;
    private int maxValue;
    private boolean earlyRepayment;
    private boolean creditLine;

    public Credit(Bank bank, double interestRate, int term, int minValue, int maxValue, boolean earlyRepayment, boolean creditLine) {
        this.bank = bank;
        this.interestRate = interestRate;
        this.term = term;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.earlyRepayment = earlyRepayment;
        this.creditLine = creditLine;
    }

    @Override
    public String toString() {
        return bank.getBankName() +
                "  interestRate = " + String.format("%.2g",(interestRate + bank.countMinInterestRate(refinancingRate)) * 100) + "%" +
                ", term = " + term +
                ", minValue = " + minValue +
                ", maxValue = " + maxValue +
                ", earlyRepayment = " + (earlyRepayment ? "Yes" : "No") +
                ", creditLine = " + (creditLine ? "Yes" : "No");
    }

    public abstract double countSum(double loan);

    public abstract Double countOverpayment();

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getRefinancingRate() {
        return refinancingRate;
    }

    public void setRefinancingRate(double refinancingRate) {
        this.refinancingRate = refinancingRate;
    }

    public boolean isEarlyRepayment() {
        return earlyRepayment;
    }

    public void setEarlyRepayment(boolean earlyRepayment) {
        this.earlyRepayment = earlyRepayment;
    }

    public boolean isCreditLine() {
        return creditLine;
    }

    public void setCreditLine(boolean creditLine) {
        this.creditLine = creditLine;
    }
}
