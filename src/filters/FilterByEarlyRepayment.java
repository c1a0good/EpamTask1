package filters;

import credits.Credit;

public class FilterByEarlyRepayment extends Filter <Boolean> {
    public FilterByEarlyRepayment(boolean criteria) {
        super(criteria);
    }

    @Override
    public boolean check(Credit credit) {
        return criteria == credit.isEarlyRepayment();
    }
}
