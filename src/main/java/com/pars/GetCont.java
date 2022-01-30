package com.pars;

import com.pars.comparators.*;
import org.jsoup.nodes.Document;
import java.util.Comparator;
import java.util.List;

public class GetCont extends GetContentAbstract {

    private final int page;
    private final int choise;
    private final BashClient client;

    GetCont(int page, int choise, BashClient client) {
        this.page = page;
        this.choise = choise;
        this.client = client;
    }

    void parsing() throws Exception {
        Document doc = client.getDocument(page,"index");
        List<Parser> pars = getParser(doc);

        if (choise > 0) {
            Comparator<Parser> comparator = selectComparator();
            pars.sort(comparator);
        }

        for (Parser par : pars) {
            System.out.println(par);
        }
    }

    private Comparator<Parser> selectComparator() {

        if (choise == 1) {
            return new SortVote();
        } else if (choise == 2) {
            return new SortVoteDown();
        } else if (choise == 3) {
            return new SortId();
        } else if (choise == 4) {
            return new SortIdDown();
        } else if (choise == 5) {
            return new SortDate();
        } else if (choise == 6) {
            return new SortDateDown();
        }
        throw new IllegalArgumentException("Please, enter the mode correct - " + choise);
    }
}
