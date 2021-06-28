package com.mproductions.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class MemoView {

    public View getView() {
        try {
            View view = FXMLLoader.load(FreestyleView.class.getResource("fourth.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
