package comporators;

import credits.Credit;

import java.util.Comparator;

public class BankNameComparator implements Comparator<Credit> {
    @Override
    public int compare(Credit o1, Credit o2) {
        return o1.getBank().getBankName().compareTo(o2.getBank().getBankName());
    }
}
