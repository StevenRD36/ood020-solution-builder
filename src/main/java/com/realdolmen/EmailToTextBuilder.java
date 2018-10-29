package com.realdolmen;

public class EmailToTextBuilder implements EmailBuilder {

    private Email email;

    public EmailToTextBuilder() {
        email = new Email();
    }

    @Override
    public EmailBuilder setFrom(String from) {
        email.setFrom(from);
        return this;
    }

    @Override
    public EmailBuilder setTo(String to) {
        email.setTo(to);
        return this;
    }

    @Override
    public EmailBuilder setSubject(String subject) {
        email.setSubject(subject);
        return this;
    }

    @Override
    public EmailBuilder setBody(String body) {
        email.setBody(body);
        return this;
    }

    @Override
    public String build() {

        return email.toString();
    }
}
