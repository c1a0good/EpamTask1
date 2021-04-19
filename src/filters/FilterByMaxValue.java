package filters;

import credits.Credit;

public class FilterByMaxValue extends Filter <Integer> {
    public FilterByMaxValue(Integer criteria) {
        super(criteria);
    }

    @Override
    public boolean check(Credit credit) {
        return criteria <= credit.getMaxValue();
    }
}
