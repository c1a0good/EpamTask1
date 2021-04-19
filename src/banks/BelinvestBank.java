package banks;

public class BelinvestBank implements Bank {
    public double countMinInterestRate(double refinancingRate) {
        return refinancingRate + .01;
    }

    public String getBankName() {
        return "BelinvestBank";
    }
}
