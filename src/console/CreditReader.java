package console;

import banks.BelarusBank;
import banks.BelinvestBank;
import banks.SberBank;
import banks.SpecificBank;
import comporators.BankNameComparator;
import comporators.CreditOverpaymentComparator;
import credits.Credit;
import credits.DefaultCredit;


import java.util.ArrayList;

public class CreditReader {
    public static ArrayList<Credit> creditReader() {
        ArrayList<Credit> credits = new ArrayList<>();
        credits.add(new DefaultCredit(new BelarusBank(), .03d, 12, 30, 1000, true, false));
        credits.add(new DefaultCredit(new BelinvestBank(), .03d, 12, 100, 1200, false, false));
        credits.add(new DefaultCredit(new SberBank(), .05d, 6, 70, 500, true, true));
        credits.add(new DefaultCredit(new BelarusBank(), .01d, 36, 350, 5000, false, true));
        credits.add(new DefaultCredit(new SpecificBank(), .02d, 30, 1100, 12000, false, false));
        credits.sort(new BankNameComparator().thenComparing(new CreditOverpaymentComparator()));
        return credits;
    }
}
