package com.mproductions.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AnalyzerPresenter extends AnalyzerLogic {

    @FXML
    private View fifth;
    @FXML
    public Label label;

    public void initialize() {
        fifth.setShowTransitionFactory(BounceInRightTransition::new);

        fifth.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Menu");
            }
        });

        InitAnalyzer();
    }

}
