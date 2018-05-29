package com.goo.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by TIO BIGA on 25/03/2018.
 */

public class PreferencesUtils {

    public static FreeTypeFontGenerator generateCrackManFont() {
        return new FreeTypeFontGenerator(Gdx.files.internal("fonts/crackman.ttf"));
    }

    public static Label createText(FreeTypeFontGenerator generator, int size, float borderWidth, Color color,
                                   int shadowOffsetX, int shadowOffsetY, Color shadowColor, String text,
                                   float sizex, float sizey, float posx, float posy) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.borderWidth = borderWidth;
        parameter.color = color;
        parameter.shadowOffsetX = shadowOffsetX;
        parameter.shadowOffsetY = shadowOffsetY;
        parameter.shadowColor = shadowColor;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        Label label = new Label(text,labelStyle);
        label.setSize(sizex,sizey);
        label.setPosition(posx,posy);
        return label;
    }
}
