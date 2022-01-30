package com.pars;

import java.util.Comparator;

public class SortId implements Comparator<Parser> {
    @Override
    public int compare(Parser o1, Parser o2) {
        return o2.getId().compareTo(o1.getId());
    }
}
