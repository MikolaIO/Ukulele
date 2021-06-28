package com.mproductions;

import com.gluonhq.attach.lifecycle.LifecycleService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import static com.mproductions.Main.PRIMARY_VIEW;
import static com.mproductions.Main.FREESTYLE_VIEW;
import static com.mproductions.Main.RYTHM_VIEW;
import static com.mproductions.Main.MEMO_VIEW;
import static com.mproductions.Main.ANALYZER_VIEW;


public class DrawerManager {

    public static void buildDrawer(MobileApplication app) {
        NavigationDrawer drawer = app.getDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("Rex",
                "Assistant",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        
        final Item primaryItem = new ViewItem("Menu", MaterialDesignIcon.HOME.graphic(), PRIMARY_VIEW, ViewStackPolicy.SKIP);
        final Item secondaryItem = new ViewItem("FreeStyle", MaterialDesignIcon.GRAPHIC_EQ.graphic(), FREESTYLE_VIEW);
        final Item thirdItem = new ViewItem("Rythm", MaterialDesignIcon.GRAPHIC_EQ.graphic(), RYTHM_VIEW);
        final Item fourthItem = new ViewItem("Memo", MaterialDesignIcon.GRAPHIC_EQ.graphic(), MEMO_VIEW);
        final Item fifthItem = new ViewItem("Spectrum Analyzer", MaterialDesignIcon.GRAPHIC_EQ.graphic(), ANALYZER_VIEW);
        drawer.getItems().addAll(primaryItem, secondaryItem, thirdItem, fourthItem, fifthItem);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}