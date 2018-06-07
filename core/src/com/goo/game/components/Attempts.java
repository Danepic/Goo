package com.goo.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.NumericInputListenerUtils;

public class Attempts extends Actor {

    private Label attempts;
    private int limitAttempt;
    public int currentAttempt = 0;

    public Attempts(int limitAttempt) {
        this.limitAttempt = limitAttempt;

        attempts = FontUtils.createText(FontUtils.generateCrackManFont(), 70, 1, Color.WHITE,
                3, 3, new Color(0, 0.5f, 0, 0.75f), currentAttempt+"/"+this.limitAttempt,
                50, 50, (Gdx.graphics.getWidth()/2) - 75, (Gdx.graphics.getHeight()/2) - 325);
    }

    public Label getAttempts() {
        return attempts;
    }

    public void setAttempts(Label attempts) {
        this.attempts = attempts;
    }

    public int getLimitAttempt() {
        return limitAttempt;
    }

    public void setLimitAttempt(int limitAttempt) {
        this.limitAttempt = limitAttempt;
    }
}
