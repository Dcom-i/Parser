package com.pars;

public class ParserQuote {

    String id;
    String vote;
    String date;
    String content;

    public ParserQuote(String id, String vote, String date, String content) {
        this.id = id;
        this.vote = vote;
        this.date = date;
        this.content = content;
    }

    public String toString() {
        return "ID-" + this.id + "\n (Vote-" + this.vote + ") \n " + this.date + "\n " + this.content;
    }
}
