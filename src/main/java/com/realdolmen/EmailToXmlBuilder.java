package com.realdolmen;

public class EmailToXmlBuilder implements EmailBuilder {

    private String metaXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private String messageXml = "<message>";
    private String messageCloseXml = "</message>";

    private String fromXml = "<from>";
    private String fromCloseXml = "</from>";

    private String toXml = "<to>";
    private String toCloseXml = "</to>";

    private String subXml = "<subject>";
    private String subCloseXml = "</subject>";

    private String bodyXml = "<body>";
    private String bodyCloseXml = "</body>";

    private StringBuilder stringBuilder;

    public EmailToXmlBuilder() {
        stringBuilder = new StringBuilder(metaXml).append("\n").append(messageXml).append("\n");
    }

    @Override
    public EmailBuilder setFrom(String from) {
        stringBuilder.append(fromXml).append(from).append(fromCloseXml).append("\n");
        return this;
    }

    @Override
    public EmailBuilder setTo(String to) {
        stringBuilder.append(toXml).append(to).append(toCloseXml).append("\n");
        return this;
    }

    @Override
    public EmailBuilder setSubject(String subject) {
        stringBuilder.append(subXml).append(subject).append(subCloseXml).append("\n");
        return this;
    }

    @Override
    public EmailBuilder setBody(String body) {
        stringBuilder.append(bodyXml).append(body).append(bodyCloseXml).append("\n");
        return this;
    }

    @Override
    public String build() {
        stringBuilder.append(messageCloseXml);
        return stringBuilder.toString();
    }


}
