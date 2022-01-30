package com.pars;

import java.util.Comparator;

public class SortVote implements Comparator<Parser> {
    @Override
    public int compare(Parser o1, Parser o2) {
        int temp = o2.getVote().compareTo(o1.getVote());
        if (temp == 0) {
            return o1.getDate().compareTo(o2.getDate());
        }
        return temp;
    }
}
