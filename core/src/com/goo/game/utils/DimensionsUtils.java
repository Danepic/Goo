package com.goo.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class DimensionsUtils {

    public static int getTotalX() {
        return Gdx.graphics.getWidth();
    }

    public static int getMeioX() {
        return Gdx.graphics.getWidth() / 2;
    }

    public static int getTotalY() {
        return Gdx.graphics.getHeight();
    }

    public static int getMeioY() {
        return Gdx.graphics.getHeight()/2;
    }
}
