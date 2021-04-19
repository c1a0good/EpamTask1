package credits;
import banks.Bank;

public class DefaultCredit extends Credit {
    public DefaultCredit(Bank bank, double interestRate, int term, int minValue, int maxValue, boolean earlyRepaiment, boolean creditLine){
        super(bank, interestRate, term, minValue, maxValue, earlyRepaiment, creditLine);
    }

    @Override
    public double countSum(double loan) {
        return (1d + countOverpayment()) * loan;
    }

    @Override
    public Double countOverpayment(){
        return (getInterestRate() + getBank().countMinInterestRate(getRefinancingRate())) / 12d * getTerm();
    }
}
