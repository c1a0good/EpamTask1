package console;

import credits.Credit;
import filters.Filter;

import java.util.ArrayList;

public class Searcher {
    public static <T> ArrayList<Credit> search(Filter<T> filter, ArrayList<Credit> credits) {
        ArrayList<Credit> filteredArray = new ArrayList<>();
        for (Credit credit : credits) {
            if (filter.check(credit)) {
                filteredArray.add(credit);
            }
        }
        return filteredArray;
    }
}