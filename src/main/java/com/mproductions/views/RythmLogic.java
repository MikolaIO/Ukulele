package com.mproductions.views;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.util.ArrayList;

public class RythmLogic {

    @FXML
    private Button btnStart;
    @FXML
    private Button btnC1;
    @FXML
    private Button btnG1;
    @FXML
    private Button btnAm1;
    @FXML
    private Button btnF1;
    @FXML
    private Button btnC2;
    @FXML
    private Button btnG2;
    @FXML
    private Button btnAm2;
    @FXML
    private Button btnF2;
    @FXML
    private Button btnC3;
    @FXML
    private Button btnG3;
    @FXML
    private Button btnAm3;
    @FXML
    private Button btnF3;
    @FXML
    private Button btnC4;
    @FXML
    private Button btnG4;
    @FXML
    private Button btnAm4;
    @FXML
    private Button btnF4;

    private ArrayList<Timer> timers;
    private String pathC = "file:src/main/resources/com/mproductions/views/sound/C.mp3";
    private String pathG = "file:src/main/resources/com/mproductions/views/sound/G.mp3";
    private String pathAm = "file:src/main/resources/com/mproductions/views/sound/Am.mp3";
    private String pathF = "file:src/main/resources/com/mproductions/views/sound/F.mp3";

    private void KeyframeStep(ActionEvent actionEvent, Timer tim) {
        tim.IterateCounter();
        tim.counterlabel.setText(String.valueOf(tim.GetCounter()));
        AudioClip clip = new AudioClip(tim.GetAudioPath());
        clip.play();
    }

    public ArrayList<Timer> getTimers() {
        return timers;
    }

    public void InitRythm()
    {
        timers = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            timers.add(new Timer());

        btnStart.setOnMouseClicked((MouseEvent event) -> {
            for (Timer tim : timers) {
                if ((tim.timerfield.getText().isEmpty() || tim.GetAudioPath() == null || tim.GetAudioPath().isEmpty()))
                    return;

                tim.SetTime(tim.timerfield.getText());
                tim.timeline = new Timeline(new KeyFrame(Duration.millis(tim.GetTime()), actionEvent -> KeyframeStep(actionEvent, tim)));
                tim.timeline.setCycleCount(Timeline.INDEFINITE);
                tim.Start();
            }
        });
        btnC1.setOnMouseClicked((MouseEvent event) -> {
            timers.get(0).SetAudioPath(pathC);
        });
        btnG1.setOnMouseClicked((MouseEvent event) -> {
            timers.get(0).SetAudioPath(pathG);
        });
        btnAm1.setOnMouseClicked((MouseEvent event) -> {
            timers.get(0).SetAudioPath(pathAm);
        });
        btnF1.setOnMouseClicked((MouseEvent event) -> {
            timers.get(0).SetAudioPath(pathF);
        });
        btnC2.setOnMouseClicked((MouseEvent event) -> {
            timers.get(1).SetAudioPath(pathC);
        });
        btnG2.setOnMouseClicked((MouseEvent event) -> {
            timers.get(1).SetAudioPath(pathG);
        });
        btnAm2.setOnMouseClicked((MouseEvent event) -> {
            timers.get(1).SetAudioPath(pathAm);
        });
        btnF2.setOnMouseClicked((MouseEvent event) -> {
            timers.get(1).SetAudioPath(pathF);
        });
        btnC3.setOnMouseClicked((MouseEvent event) -> {
            timers.get(2).SetAudioPath(pathC);
        });
        btnG3.setOnMouseClicked((MouseEvent event) -> {
            timers.get(2).SetAudioPath(pathG);
        });
        btnAm3.setOnMouseClicked((MouseEvent event) -> {
            timers.get(2).SetAudioPath(pathAm);
        });
        btnF3.setOnMouseClicked((MouseEvent event) -> {
            timers.get(2).SetAudioPath(pathF);
        });
        btnC4.setOnMouseClicked((MouseEvent event) -> {
            timers.get(3).SetAudioPath(pathC);
        });
        btnG4.setOnMouseClicked((MouseEvent event) -> {
            timers.get(3).SetAudioPath(pathG);
        });
        btnAm4.setOnMouseClicked((MouseEvent event) -> {
            timers.get(3).SetAudioPath(pathAm);
        });
        btnF4.setOnMouseClicked((MouseEvent event) -> {
            timers.get(3).SetAudioPath(pathF);
        });
    }
}
