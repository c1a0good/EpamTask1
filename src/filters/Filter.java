package filters;

import credits.Credit;

public abstract class Filter <T> {
    protected T criteria;

    public Filter(T criteria) {
        this.criteria = criteria;
    }

    public abstract boolean check(Credit credit);

    public T getCriteria() {
        return criteria;
    }

    public void setCriteria(T criteria) {
        this.criteria = criteria;
    }
}
