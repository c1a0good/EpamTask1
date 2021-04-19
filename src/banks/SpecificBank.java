package banks;

public class SpecificBank implements Bank {
    public double countMinInterestRate(double refinancingRate) {
        return refinancingRate + .015;
    }

    public String getBankName() {
        return "Specific Bank";
    }
}
