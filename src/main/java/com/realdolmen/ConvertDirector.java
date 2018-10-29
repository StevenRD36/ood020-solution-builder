package com.realdolmen;

public class ConvertDirector {

    private MyFileReader myFileReader;
    private MyFileWriter myFileWriter;
    private EmailBuilder emailBuilder;

    private static final String PATH = "C:\\Users\\sdoax36\\Documents\\emails\\";


    public ConvertDirector(EmailBuilder emailBuilder) {
        this.emailBuilder = emailBuilder;
        myFileReader = new MyFileReader(this.emailBuilder);
        myFileWriter = new MyFileWriter();
    }

    public String createEmailString(String to, String from, String subject, String body) {
        return emailBuilder.setFrom(from).setTo(to).setSubject(subject).setBody(body).build();
    }

    public void startConverting(String location) {
        myFileReader.readFile(location);
    }

    public void convertFile(String fileName, String content) {
        myFileWriter.writeToFile(PATH+fileName, content);
    }

}
