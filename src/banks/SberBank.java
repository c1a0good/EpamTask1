package banks;

public class SberBank implements Bank {
    public double countMinInterestRate(double refinancingRate) {
        return refinancingRate;
    }

    public String getBankName() {
        return "SberBank";
    }
}
