package com.goo.game.utils;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

/**
 * Created by TIO BIGA on 01/04/2018.
 */

public class StyleUtils {

    private SelectBox.SelectBoxStyle style;

    public static SelectBox selectBoxStyleLanguage(Skin skin, int posx, int posy){
        final SelectBox selectBox = new SelectBox(skin);
        Array<String> items = new Array<String>();
        items.add("English");
        items.add("Portugues");
        selectBox.setPosition(posx, posy);
        selectBox.setWidth(400);
        selectBox.setAlignment(Align.left);
        selectBox.getStyle().background.setRightWidth(20);
        selectBox.getStyle().background.setLeftWidth(20);
        selectBox.getList().setAlignment(Align.left);
        selectBox.getStyle().listStyle.selection.setRightWidth(20);
        selectBox.getStyle().listStyle.selection.setLeftWidth(20);
        selectBox.setItems(items);
        selectBox.setSelected(items.get(0));
        return selectBox;
    }

}
