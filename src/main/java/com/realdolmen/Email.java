package com.realdolmen;

public class Email {

    private String from;
    private String subject;
    private String to;
    private String body;


    public String getFrom() {
        return from;
    }

    public Email setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getTo() {
        return to;
    }

    public Email setTo(String to) {
        this.to = to;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Email setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        return "From: " + from + "\n" +
                "To: " + to + "\n" + "Subject: " + subject + "\n" +
                body + "\n";
    }
}
