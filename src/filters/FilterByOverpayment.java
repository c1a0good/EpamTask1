package filters;

import credits.Credit;

public class FilterByOverpayment extends Filter <Double> {
    public FilterByOverpayment(Double criteria) {
        super(criteria);
    }

    @Override
    public boolean check(Credit credit) {
        return criteria >= credit.countOverpayment();
    }
}
