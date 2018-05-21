package com.goo.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by TIO BIGA on 11/05/2018.
 */

public class StringInputListenerUtils implements Input.TextInputListener {

    private String text;

    public void input(String text) {
        this.text = text;
    }

    @Override
    public void canceled() {
        this.text = null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
