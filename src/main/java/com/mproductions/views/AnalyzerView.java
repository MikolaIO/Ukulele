package com.mproductions.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class AnalyzerView {

    public View getView() {
        try {
            View view = FXMLLoader.load(getClass().getResource("analyzer.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
