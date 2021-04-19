package filters;

import credits.Credit;

public class FilterByCreditLine extends Filter <Boolean> {
    public FilterByCreditLine(Boolean criteria) {
        super(criteria);
    }

    @Override
    public boolean check(Credit credit) {
        return criteria == credit.isCreditLine();
    }
}
