package com.pars;

import java.util.Comparator;

public class SortIdDown implements Comparator<Parser> {
    @Override
    public int compare(Parser o1, Parser o2) {
        return o1.getId().compareTo(o2.getId());
    }
}