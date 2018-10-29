package com.realdolmen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileWriter {

    public void writeToFile(String pathToFile, String email) {
        Path path = Paths.get(pathToFile);
        BufferedWriter bufferedWriter = null;
        try {
            Files.createFile(path);
            bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path)));
            bufferedWriter.write(email);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
