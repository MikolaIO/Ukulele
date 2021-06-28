package com.mproductions.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.AudioClip;

public class FreestylePresenter {

    private final String pathG = "file:src/main/resources/com/mproductions/views/sound/G.mp3";
    private final String pathC = "file:src/main/resources/com/mproductions/views/sound/C.mp3";
    private final String pathE = "file:src/main/resources/com/mproductions/views/sound/E.mp3";
    private final String pathA = "file:src/main/resources/com/mproductions/views/sound/A.mp3";
    private final String pathF = "file:src/main/resources/com/mproductions/views/sound/F.mp3";
    private final String pathGm = "file:src/main/resources/com/mproductions/views/sound/Gm.mp3";
    private final String pathCm = "file:src/main/resources/com/mproductions/views/sound/Cm.mp3";
    private final String pathEm = "file:src/main/resources/com/mproductions/views/sound/Em.mp3";
    private final String pathAm = "file:src/main/resources/com/mproductions/views/sound/Am.mp3";
    private final String pathFm = "file:src/main/resources/com/mproductions/views/sound/Fm.mp3";

    @FXML
    private View secondary;

    public void initialize() {
        secondary.setShowTransitionFactory(BounceInRightTransition::new);
        
        secondary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("FreeStyle");
            }
        });
    }

    public void HandleBtnG(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathG);
        clip.play();
    }

    public void HandleBtnC(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathC);
        clip.play();
    }

    public void HandleBtnE(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathE);
        clip.play();
    }

    public void HandleBtnA(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathA);
        clip.play();
    }

    public void HandleBtnF(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathF);
        clip.play();
    }

    public void HandleBtnGm(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathGm);
        clip.play();
    }

    public void HandleBtnCm(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathCm);
        clip.play();
    }

    public void HandleBtnEm(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathEm);
        clip.play();
    }

    public void HandleBtnAm(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathAm);
        clip.play();
    }

    public void HandleBtnFm(ActionEvent actionEvent) {
        AudioClip clip = new AudioClip(pathFm);
        clip.play();
    }
}
