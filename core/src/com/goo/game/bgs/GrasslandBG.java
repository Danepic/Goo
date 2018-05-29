package com.goo.game.bgs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.goo.game.utils.PathUtils;

/**
 * Created by TIO BIGA on 26/05/2018.
 */

public class GrasslandBG extends Actor {
    private Image image;

    public GrasslandBG() {
        this.image = PathUtils.image("background/01bg.png", 450, 275, 1.40f, 1.40f, true);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
