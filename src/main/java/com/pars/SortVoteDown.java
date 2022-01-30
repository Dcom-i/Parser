package com.pars;

import java.util.Comparator;

public class SortVoteDown implements Comparator<Parser> {
    @Override
    public int compare(Parser o1, Parser o2) {
        int temp = o1.getVote().compareTo(o2.getVote());
        if (temp == 0) {
            return o1.getDate().compareTo(o2.getDate());
        }
        return temp;
    }
}
