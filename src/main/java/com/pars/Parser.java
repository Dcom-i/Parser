package com.pars;

public class Parser {

    private final String id;
    private final String vote;
    private final String date;
    private final String content;

    public Parser(String id, String vote, String date, String content) {
        this.id = id;
        this.vote = vote;
        this.date = date;
        this.content = content;
    }

    public String toString() {
        return " " + this.id + " (Vote-" + this.vote + ") " + this.date + " " + this.content;
    }

    public String getId() {
        return id;
    }

    public String getVote() {
        return vote;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
