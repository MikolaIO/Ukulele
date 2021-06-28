package com.mproductions.views;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MemoLogic {
    @FXML
    public Label stateLabel;
    @FXML
    public CheckBox checkbox;
    @FXML
    public CheckBox checkbox1;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnG;
    @FXML
    private Button btnC;
    @FXML
    private Button btnE;
    @FXML
    private Button btnA;
    @FXML
    private Button btnF;
    @FXML
    private Button btnGm;
    @FXML
    private Button btnCm;
    @FXML
    private Button btnEm;
    @FXML
    private Button btnAm;
    @FXML
    private Button btnFm;

    private final String pathG = "file:src/sound/G.mp3";      //paths to sounds
    private final String pathC = "file:src/sound/C.mp3";
    private final String pathE = "file:src/sound/E.mp3";
    private final String pathA = "file:src/sound/A.mp3";
    private final String pathF = "file:src/sound/F.mp3";
    private final String pathGm = "file:src/sound/Gm.mp3";
    private final String pathCm = "file:src/sound/Cm.mp3";
    private final String pathEm = "file:src/sound/Em.mp3";
    private final String pathAm = "file:src/sound/Am.mp3";
    private final String pathFm = "file:src/sound/Fm.mp3";
    private boolean GStatus;
    private boolean CStatus;
    private boolean EStatus;
    private boolean AStatus;
    private boolean FStatus;
    private boolean GmStatus;
    private boolean CmStatus;
    private boolean EmStatus;
    private boolean AmStatus;
    private boolean FmStatus;
    private KeyFrame frame1, frame2;
    private int counter;
    private Timeline timeline;

    public void HandleBtnBack(ActionEvent actionEvent) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    private void CreateNewKeyframes(Timeline timeline, Button button, boolean status, String path)
    {
        frame1 = new KeyFrame(Duration.seconds(counter * 2), e-> {  //keyframe for highlighting the button
            if (checkbox.isSelected())  //check, if easy mode is activated
                button.setStyle("-fx-background-color: red;");
            AudioClip clip = new AudioClip(path);
            clip.play();
        });
        frame2 = new KeyFrame(Duration.seconds(counter * 2 + 2), e-> {  //keyframe for going back to first state of button
            button.setStyle("-fx-background-color: lightblue;");
            ChangeStatus(status);
        });
        timeline.getKeyFrames().addAll(frame1, frame2);
    }

    private void ChangeStatus(boolean status)
    {
        status = !status;
    }

    private void EnableButtons(Button...buttons)
    {
        for (Button b : buttons)
            b.setDisable(false);
    }

    private void ResetButtonsStatus(boolean...statuses)
    {
        for (boolean s : statuses)
            s = false;
    }

    private void PrintGuess(boolean status)
    {
        if (status)
            stateLabel.setText("Nice hearing!");
        else
            stateLabel.setText("Try another!");
    }

    public void HandleBtnStart(ActionEvent actionEvent) throws InterruptedException {

        counter = 0;    //counter of actions
        int rand = 0;   //random value for memo
        int compare = 1;
        int tries = 3;
        if (checkbox1.isSelected()) //check, if hardcore is activated
            tries = 9;
        timeline = new Timeline();
        EnableButtons(btnG, btnC, btnE, btnA, btnF, btnGm, btnCm, btnEm, btnAm, btnFm);
        btnStart.setText("Restart");
        ResetButtonsStatus(GStatus, CStatus, EStatus, AStatus, FStatus, GmStatus, CmStatus, EmStatus, AmStatus, FmStatus);

        while(counter < tries) {
            rand = ((int) (Math.random() * 10) + 1);    //first pass

            while (rand == compare)
                rand = ((int) (Math.random() * 10) + 1);    //second pass, until next value won't be duplicate

            switch (rand) {
                case 0:
                    CreateNewKeyframes(timeline, btnG, GStatus, pathG);
                    break;
                case 1:
                    CreateNewKeyframes(timeline, btnC, CStatus, pathC);
                    break;
                case 2:
                    CreateNewKeyframes(timeline, btnE, EStatus, pathE);
                    break;
                case 3:
                    CreateNewKeyframes(timeline, btnA, AStatus, pathA);
                    break;
                case 4:
                    CreateNewKeyframes(timeline, btnF, FStatus, pathF);
                    break;
                case 5:
                    CreateNewKeyframes(timeline, btnGm, GmStatus, pathGm);
                    break;
                case 6:
                    CreateNewKeyframes(timeline, btnCm, CmStatus, pathCm);
                    break;
                case 7:
                    CreateNewKeyframes(timeline, btnEm, EmStatus, pathEm);
                    break;
                case 8:
                    CreateNewKeyframes(timeline, btnAm, AmStatus, pathAm);
                    break;
                case 9:
                    CreateNewKeyframes(timeline, btnFm, FmStatus, pathFm);
                    break;
            }
            counter++;
            compare = rand; //remember the previous value of random number
        }
        timeline.play();
    }

    public void HandleBtnG(ActionEvent actionEvent) {
        PrintGuess(GStatus);
    }
    public void HandleBtnC(ActionEvent actionEvent) {
        PrintGuess(CStatus);
    }
    public void HandleBtnE(ActionEvent actionEvent) {
        PrintGuess(EStatus);
    }
    public void HandleBtnA(ActionEvent actionEvent) {
        PrintGuess(AStatus);
    }
    public void HandleBtnF(ActionEvent actionEvent) {
        PrintGuess(FStatus);
    }
    public void HandleBtnGm(ActionEvent actionEvent) {
        PrintGuess(GmStatus);
    }
    public void HandleBtnCm(ActionEvent actionEvent) {
        PrintGuess(CmStatus);
    }
    public void HandleBtnEm(ActionEvent actionEvent) {
        PrintGuess(EmStatus);
    }
    public void HandleBtnAm(ActionEvent actionEvent) {
        PrintGuess(AmStatus);
    }
    public void HandleBtnFm(ActionEvent actionEvent) {
        PrintGuess(FmStatus);
    }

}
