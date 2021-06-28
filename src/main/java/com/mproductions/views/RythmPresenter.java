package com.mproductions.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;


public class RythmPresenter extends RythmLogic {

    @FXML
    private View third;
    @FXML
    private GridPane gridpane;

    public void initialize() {
        third.setShowTransitionFactory(BounceInRightTransition::new);

        third.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Rythm");
            }
        });

        InitRythm();
        gridpane.add(getTimers().get(0).timerfield, 0,4);
        gridpane.add(getTimers().get(1).timerfield, 1,4);
        gridpane.add(getTimers().get(2).timerfield, 2,4);
        gridpane.add(getTimers().get(3).timerfield, 3,4);
    }
}
