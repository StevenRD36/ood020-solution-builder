package com.realdolmen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyFileReader {

    private EmailBuilder emailBuilder;

    public MyFileReader(EmailBuilder emailBuilder) {
        this.emailBuilder = emailBuilder;
    }

    public void readFile(String location) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(location);
        try {
            readFromInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromInputStream(InputStream inputStream) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                checkInput(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
    }

    private void checkInput(String line) {

        if (line.startsWith("From:")) {
            emailBuilder.setFrom(line.substring(line.indexOf(":") + 1));
        } else if (line.startsWith("To:")) {
            emailBuilder.setTo(line.substring(line.indexOf(":") + 1));
        } else if (line.startsWith("Subject:")) {
            emailBuilder.setSubject(line.substring(line.indexOf(":") + 1));
        } else {
            emailBuilder.setBody(line.substring(line.indexOf(":") + 1));
        }
    }
}
