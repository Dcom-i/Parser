package com.pars;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetContentById extends GetContentAbstract  {

    private final int quote;
    private final BashClient client;

    GetContentById(int quote, BashClient client) {
        this.quote = quote;
        this.client = client;
    }

    void ParsingQuote() throws IOException {
        Document doc = client.getDocument(quote, "quote");
        List<Parser> pars = getParser(doc);
        System.out.println(pars);
    }
}
