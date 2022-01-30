package com.pars.comparators;

import com.pars.Parser;

import java.util.Comparator;

public class SortDate implements Comparator<Parser> {

    @Override
    public int compare(Parser o1, Parser o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
