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
        gridpane.add(getTimers().get(FIRST_TIMER).timerfield, FIRST_TIMER,TIMER_ROW);
        gridpane.add(getTimers().get(SECOND_TIMER).timerfield, SECOND_TIMER,TIMER_ROW);
        gridpane.add(getTimers().get(THIRD_TIMER).timerfield, THIRD_TIMER,TIMER_ROW);
        gridpane.add(getTimers().get(FOURTH_TIMER).timerfield, FOURTH_TIMER,TIMER_ROW);
    }
}
