package filters;

import credits.Credit;

public class FilterByMinValue extends Filter <Integer> {
    public FilterByMinValue(Integer criteria) {
        super(criteria);
    }

    @Override
    public boolean check(Credit credit) {
        return criteria >= credit.getMinValue();
    }
}
