package com.realdolmen;

public interface EmailBuilder {

    public EmailBuilder setFrom(String from);
    public EmailBuilder setTo(String to);
    public EmailBuilder setSubject(String subject);
    public EmailBuilder setBody(String body);

    public String build();
}
