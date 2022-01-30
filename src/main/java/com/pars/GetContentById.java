package com.pars;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetContentById extends Bash {

    private final int quote;

    GetContentById(int quote) {
        this.quote = quote;
    }

    void ParsingQuote() throws IOException {
        List<ParserQuote> pars = getParserQuote();
        System.out.println(pars);
    }

    private Document getDocumentByPage() throws IOException {
        return Jsoup.connect("https://bash.im/quote/" + quote).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
    }

    private List<ParserQuote> getParserQuote() throws IOException {
        List<ParserQuote> pars = new ArrayList<>();
        Document doc = getDocumentByPage();
        for (Element list : doc.getElementsByAttributeValue("class", "quote")) {
            ParserQuote item = parsItemQuote(list);
            pars.add(item);
        }
        return pars;
    }

    private ParserQuote parsItemQuote(Element list) {
        Elements id = list.getElementsByClass("quote__header_permalink");
        Elements vote = list.getElementsByClass("quote__total");
        Elements date = list.getElementsByClass("quote__header_date");
        Elements content = list.getElementsByClass("quote__body");
        String pid = id.text();
        String pvote = vote.text();
        String pdate = date.text();
        String pcontent = content.text();
        return new ParserQuote(pid, pvote, pdate, pcontent);
    }
}
