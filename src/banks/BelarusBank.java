package banks;

public class BelarusBank implements Bank {
    public double countMinInterestRate(double refinancingRate) {
        return refinancingRate + .02;
    }

    public String getBankName() {
        return "BelarusBank";
    }
}