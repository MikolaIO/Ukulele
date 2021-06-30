package com.mproductions.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class RythmView {

    public View getView() {
        try {
            View view = FXMLLoader.load(getClass().getResource("rythm.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
