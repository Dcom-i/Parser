package com.pars.comparators;

import com.pars.Parser;

import java.util.Comparator;

public class SortDateDown implements Comparator<Parser> {

    @Override
    public int compare(Parser o1, Parser o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}