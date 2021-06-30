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

    public static final int FIRST_TIMER = 0;
    public static final int SECOND_TIMER = 1;
    public static final int THIRD_TIMER = 2;
    public static final int FOURTH_TIMER = 3;
    public static final int TIMER_ROW = 4;

    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
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
    private final String pathC = "file:src/main/resources/com/mproductions/views/sound/C.mp3";
    private final String pathG = "file:src/main/resources/com/mproductions/views/sound/G.mp3";
    private final String pathAm = "file:src/main/resources/com/mproductions/views/sound/Am.mp3";
    private final String pathF = "file:src/main/resources/com/mproductions/views/sound/F.mp3";

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
        btnStop.setOnMouseClicked((MouseEvent event) -> {
            for (Timer tim : timers) {
                if ((tim.timerfield.getText().isEmpty() || tim.GetAudioPath() == null || tim.GetAudioPath().isEmpty()))
                    return;

                tim.Stop();
            }
        });
        btnC1.setOnMouseClicked((MouseEvent event) -> timers.get(FIRST_TIMER).SetAudioPath(pathC));
        btnG1.setOnMouseClicked((MouseEvent event) -> timers.get(FIRST_TIMER).SetAudioPath(pathG));
        btnAm1.setOnMouseClicked((MouseEvent event) -> timers.get(FIRST_TIMER).SetAudioPath(pathAm));
        btnF1.setOnMouseClicked((MouseEvent event) -> timers.get(FIRST_TIMER).SetAudioPath(pathF));
        btnC2.setOnMouseClicked((MouseEvent event) -> timers.get(SECOND_TIMER).SetAudioPath(pathC));
        btnG2.setOnMouseClicked((MouseEvent event) -> timers.get(SECOND_TIMER).SetAudioPath(pathG));
        btnAm2.setOnMouseClicked((MouseEvent event) -> timers.get(SECOND_TIMER).SetAudioPath(pathAm));
        btnF2.setOnMouseClicked((MouseEvent event) -> timers.get(SECOND_TIMER).SetAudioPath(pathF));
        btnC3.setOnMouseClicked((MouseEvent event) -> timers.get(THIRD_TIMER).SetAudioPath(pathC));
        btnG3.setOnMouseClicked((MouseEvent event) -> timers.get(THIRD_TIMER).SetAudioPath(pathG));
        btnAm3.setOnMouseClicked((MouseEvent event) -> timers.get(THIRD_TIMER).SetAudioPath(pathAm));
        btnF3.setOnMouseClicked((MouseEvent event) -> timers.get(THIRD_TIMER).SetAudioPath(pathF));
        btnC4.setOnMouseClicked((MouseEvent event) -> timers.get(FOURTH_TIMER).SetAudioPath(pathC));
        btnG4.setOnMouseClicked((MouseEvent event) -> timers.get(FOURTH_TIMER).SetAudioPath(pathG));
        btnAm4.setOnMouseClicked((MouseEvent event) -> timers.get(FOURTH_TIMER).SetAudioPath(pathAm));
        btnF4.setOnMouseClicked((MouseEvent event) -> timers.get(FOURTH_TIMER).SetAudioPath(pathF));
    }
}
