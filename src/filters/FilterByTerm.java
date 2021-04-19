package filters;

import credits.Credit;

public class FilterByTerm extends Filter <Integer> {
    public FilterByTerm(Integer criteria) {
        super(criteria);
    }

    @Override
    public boolean check(Credit credit) {
        return criteria <= credit.getTerm();
    }
}
