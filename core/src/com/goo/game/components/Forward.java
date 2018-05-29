package com.goo.game.components;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.goo.game.utils.NumericInputListenerUtils;
import com.goo.game.utils.PathUtils;
import com.goo.game.view.WorldScreen;

public class Forward extends Actor {

    private Image image;

    public Forward(final Game game) {
        this.image = PathUtils.image("components/elements/forward.png", Gdx.graphics.getWidth() - 150, 600, 1, 1, true);

        image.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Voltando para tela de seleção de mundos...");
                game.setScreen(new WorldScreen(game));
                return false;
            }
        });
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
