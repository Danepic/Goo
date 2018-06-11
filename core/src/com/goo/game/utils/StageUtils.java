package com.goo.game.utils;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Arrays;

public class StageUtils {
    public static Stage stageBuilder(Actor... actors){
        Stage stage = new Stage(new ScreenViewport());

        for (Actor actor: Arrays.asList(actors)) {
            stage.addActor(actor);
        }

        return stage;
    }
}
