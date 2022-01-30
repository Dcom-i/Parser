package com.pars;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class BashClient {
     Document getDocument(int id, String name) throws IOException {
        return Jsoup.connect("https://bash.im/"+name+"/" + id).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
    }
}
