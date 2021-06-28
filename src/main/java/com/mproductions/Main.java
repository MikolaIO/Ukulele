package com.mproductions;

import com.mproductions.views.*;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends MobileApplication {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String FREESTYLE_VIEW = "Freestyle View";
    public static final String RYTHM_VIEW = "Rythm View";
    public static final String MEMO_VIEW = "Memo View";
    public static final String ANALYZER_VIEW = "Analyzer View";

    @Override
    public void init() {
        addViewFactory(PRIMARY_VIEW, () -> new HomeView().getView());
        addViewFactory(FREESTYLE_VIEW, () -> new FreestyleView().getView());
        addViewFactory(RYTHM_VIEW, () -> new RythmView().getView());
        addViewFactory(MEMO_VIEW, () -> new MemoView().getView());
        addViewFactory(ANALYZER_VIEW, () -> new AnalyzerView().getView());

        DrawerManager.buildDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
    }

    public static void main(String args[]) {
        launch(args);
    }
}
