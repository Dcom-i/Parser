package com.pars;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetCont extends Bash {

    private final int page;
    private final int choise;

    GetCont(int page, int choise) {
        this.page = page;
        this.choise = choise;
    }

    void parsing() throws Exception {

        List<Parser> pars = getParsers();

        if (choise > 0) {
            Comparator<Parser> comparator = selectComparator();
            Collections.sort(pars, comparator);
        }

        for (Parser par : pars) {
            System.out.println(par);
        }
    }

    private Parser parsItem(Element list) {
        Elements id = list.getElementsByClass("quote__header_permalink");
        Elements vote = list.getElementsByClass("quote__total");
        Elements date = list.getElementsByClass("quote__header_date");
        Elements content = list.getElementsByClass("quote__body");
        String pid = id.text();
        String pVote = vote.text();
        String pDate = date.text();
        String pContent = content.text();
        return new Parser(pid, pVote, pDate, pContent);
    }

    private Document getDocumentByPage() throws IOException {
        return Jsoup.connect("https://bash.im/index/" + page).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
    }

    private List<Parser> getParsers() throws IOException {
        List<Parser> pars = new ArrayList<>();
        Document doc = getDocumentByPage();
        for (Element list : doc.getElementsByAttributeValue("class", "quote")) {
            Parser item = parsItem(list);
            pars.add(item);
        }
        return pars;
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
        throw new IllegalArgumentException("Please, enter the mode correct " + choise);
    }
}
