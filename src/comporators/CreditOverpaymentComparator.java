package comporators;

import credits.Credit;

import java.util.Comparator;

public class CreditOverpaymentComparator implements Comparator<Credit> {
    @Override
    public int compare(Credit o1, Credit o2) {
        return o1.countOverpayment().compareTo(o2.countOverpayment()) ;
    }
}
