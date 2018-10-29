package com.realdolmen;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private TextField from_txt;

    @FXML
    private TextField to_txt;

    @FXML
    private TextField subject_txt;

    @FXML
    private TextArea body_txt;


    @FXML
    private void handleButtonXmlAction(ActionEvent event) {
        if (checkFields()) {
            String fileName = subject_txt.getText() + DateUtil.getDateString() + ".xml";
            ConvertDirector convertDirector = new ConvertDirector(new EmailToXmlBuilder());
            convertDirector.convertFile(fileName, convertDirector.createEmailString(to_txt.getText(), from_txt.getText(), subject_txt.getText(), body_txt.getText()));
            navigateToFile();
            clearFields();
        }
    }

    @FXML
    private void handleButtonHtmlAction(ActionEvent event) {
        System.out.println("You clicked me!");
        if (checkFields()) {
            String fileName = subject_txt.getText() + DateUtil.getDateString() + ".html";
            ConvertDirector convertDirector = new ConvertDirector(new EmailToHtmlBuilder());
            convertDirector.convertFile(fileName, convertDirector.createEmailString(to_txt.getText(), from_txt.getText(), subject_txt.getText(), body_txt.getText()));
            navigateToFile();
            clearFields();
        }

    }


    @FXML
    private void handleButtonTextAction(ActionEvent event) {
        if (checkFields()) {
            String fileName = subject_txt.getText() + DateUtil.getDateString() + ".txt";
            ConvertDirector convertDirector = new ConvertDirector(new EmailToTextBuilder());
            convertDirector.convertFile(fileName, convertDirector.createEmailString(to_txt.getText(), from_txt.getText(), subject_txt.getText(), body_txt.getText()));
            navigateToFile();
            clearFields();
        }
    }

    private void navigateToFile() {
        try {
            Process p = new ProcessBuilder("explorer.exe", "/select,C:\\Users\\sdoax36\\Documents\\emails").start();
        } catch (IOException e) {
            System.out.println("cant open");
        }
    }

    private void clearFields() {
        to_txt.setText("");
        from_txt.setText("");
        subject_txt.setText("");
        body_txt.setText("");
    }

    private boolean checkFields() {
        if (from_txt.getText().isEmpty()) {
            from_txt.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            return false;
        }
        if (to_txt.getText().isEmpty()) {
            to_txt.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            return false;
        }
        if (subject_txt.getText().isEmpty()) {
            subject_txt.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            return false;
        }
        if (body_txt.getText().isEmpty()) {
            subject_txt.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
