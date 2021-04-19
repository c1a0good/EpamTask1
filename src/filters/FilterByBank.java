package filters;

import credits.Credit;

public class FilterByBank extends Filter <String> {
    public FilterByBank(String criteria) {
        super(criteria);
    }

    @Override
    public boolean check(Credit credit) {
        return criteria.equals(credit.getBank().getBankName());
    }
}
