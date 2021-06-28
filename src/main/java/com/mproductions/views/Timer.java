package com.mproductions.views;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Timer {

    private int time;
    private int counter;
    private String audiopath;

    public Timeline timeline;
    public Label counterlabel;
    public TextField timerfield;

    public Timer() {
        counter = 0;
        time = 2000;
        timerfield = new TextField();
        counterlabel = new Label();
    }

    public int GetTime()
    {
        return time;
    }

    public int GetCounter()
    {
        return counter;
    }

    public void SetTime(String s)
    {
        time = Integer.parseInt(s);
    }

    public void IterateCounter()
    {
        counter++;
    }

    public String GetAudioPath()
    {
        return audiopath;
    }

    public void SetAudioPath(String s)
    {
        audiopath = s;
    }

    public void Start()
    {
        timeline.play();
    }

}
