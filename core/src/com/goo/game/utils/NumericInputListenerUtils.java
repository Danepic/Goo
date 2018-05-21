package com.goo.game.utils;

import com.badlogic.gdx.Input;

/**
 * Created by TIO BIGA on 11/05/2018.
 */

public class NumericInputListenerUtils implements Input.TextInputListener {

    private Integer value;

    public void input(String text) {
        this.value = Integer.parseInt(text);
    }

    @Override
    public void canceled() {
        this.value = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
