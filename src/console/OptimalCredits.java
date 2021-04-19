package console;

import comporators.CreditOverpaymentComparator;
import credits.Credit;

import java.util.ArrayList;

public class OptimalCredits {
    public static ArrayList<Credit> getOptimalCredits(ArrayList<Credit> credits) {
        ArrayList<Credit> optimalCredits = new ArrayList<>();
        credits.sort(new CreditOverpaymentComparator());
        boolean key1, key2, key3, key4 = key3 = key2 = key1 = true;
        for (Credit credit : credits) {
            if (key1 && !credit.isCreditLine() && !credit.isEarlyRepayment()) {
                optimalCredits.add(credit);
                key1 = false;
            }
            else
            if (key2 && !credit.isCreditLine() && credit.isEarlyRepayment()) {
                optimalCredits.add(credit);
                key2 = false;
            }
            else
            if (key3 && credit.isCreditLine() && !credit.isEarlyRepayment()) {
                optimalCredits.add(credit);
                key3 = false;
            }
            else
            if (key4 && credit.isCreditLine() && credit.isEarlyRepayment()) {
                optimalCredits.add(credit);
                key4 = false;
            }
        }
        return optimalCredits;
    }
}
