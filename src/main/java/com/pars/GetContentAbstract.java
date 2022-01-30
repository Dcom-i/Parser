package com.pars;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class GetContentAbstract {
    protected Parser parsItem(Element list) {
        Elements id = list.getElementsByClass("quote__header_permalink");
        Elements vote = list.getElementsByClass("quote__total");
        Elements date = list.getElementsByClass("quote__header_date");
        Elements content = list.getElementsByClass("quote__body");
        String pid = id.text();
        String pvote = vote.text();
        String pdate = date.text();
        String pcontent = content.text();
        return new Parser(pid, pvote, pdate, pcontent);
    }

    protected List<Parser> getParser(Document doc) {
        List<Parser> pars = new ArrayList<>();
        for (Element list : doc.getElementsByAttributeValue("class", "quote")) {
            Parser item = parsItem(list);
            pars.add(item);
        }
        return pars;
    }

}
