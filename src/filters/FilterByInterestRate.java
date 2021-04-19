package filters;

import credits.Credit;

public class FilterByInterestRate extends Filter <Double> {

    public FilterByInterestRate(Double criteria) {
        super(criteria);
    }

    public boolean check(Credit credit) {
        return this.criteria >= (credit.getBank().countMinInterestRate(credit.getRefinancingRate()) + credit.getInterestRate());
    }
}
