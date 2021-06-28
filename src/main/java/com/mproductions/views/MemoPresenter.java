package com.mproductions.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MemoPresenter {

    @FXML
    private View fourth;
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

    private final String pathG = "file:src/sound/G.mp3";
    private final String pathC = "file:src/sound/C.mp3";
    private final String pathE = "file:src/sound/E.mp3";
    private final String pathA = "file:src/sound/A.mp3";
    private final String pathF = "file:src/sound/F.mp3";
    private final String pathGm = "file:src/sound/Gm.mp3";
    private final String pathCm = "file:src/sound/Cm.mp3";
    private final String pathEm = "file:src/sound/Em.mp3";
    private final String pathAm = "file:src/sound/Am.mp3";
    private final String pathFm = "file:src/sound/Fm.mp3";

    private void StartGame()
    {
        int counter = 0;
        int rand = 0;

    }

    public void initialize() {
        fourth.setShowTransitionFactory(BounceInRightTransition::new);

        fourth.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Memo");
            }
        });
    }
}
