package com.realdolmen;

public class EmailToHtmlBuilder implements EmailBuilder {

    private String metaHtml = "<!DOCTYPE html>";

    private String html = "<html>";
    private String htmlClose = "</html>";

    private String head = "<head>";
    private String headClose = "</head>";

    private String body = "<body>";
    private String bodyClose = "</body>";


    private String title = "<title>";
    private String titleClose = "</title>";



    private String tr = "<tr>";
    private String trClose = "</tr>";

    private String table = "<table>";
    private String tableClose = "</table>";

    private String td = "<td>";
    private String tdClose = "</td>";

    private String i = "<i>";
    private String iClose = "</i>";

    private StringBuilder stringBuilder;
    private Email email;

    public EmailToHtmlBuilder(){
        stringBuilder = new StringBuilder(metaHtml);
        email = new Email();
    }

    @Override
    public EmailBuilder setFrom(String from) {
        email.setFrom("From: "+from);
        return this;
    }

    @Override
    public EmailBuilder setTo(String to) {
        email.setTo("To: "+to);
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
        return createHtmlTemplate();
    }

    private String createHtmlTemplate(){
        stringBuilder.append(head)
                .append(title).append(email.getSubject()).append(titleClose)
                .append(headClose).append("\n")
                .append(body).append("\n")
                .append(table).append("\n")
                .append(tr).append(td).append(email.getFrom()).append(tdClose).append(trClose).append("\n")
                .append(tr).append(td).append(email.getTo()).append(tdClose).append(trClose).append("\n")
                .append(tr).append(td).append(email.getSubject()).append(tdClose).append(trClose).append("\n")
                .append(tr).append(td).append(email.getBody()).append(tdClose).append(trClose).append("\n")
                .append(tableClose)
                .append(bodyClose)
                .append(htmlClose);
        return stringBuilder.toString();
    }
}
