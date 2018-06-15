package com.goo.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.goo.game.utils.FontUtils;

public class Toast extends Actor {

    private Texture texture;
    private Label label;
    private Boolean flagStart = false;

    public Toast(String path, float posx, float posy, String label) {
        this.texture = new Texture(path);

        this.label = FontUtils.createText(FontUtils.generateCrackManFont(), 34, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, label,
                50, 50, posx + 500, posy - 10);

        this.setWidth(texture.getWidth());
        this.setHeight(texture.getHeight());
        this.setPosition(posx, posy);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY());
    }

    @Override
    public void act(float delta) {
        this.label.setX(this.getX() + 53);
        this.label.setY(this.getY() + 40);
        super.act(delta);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label varName) {
        this.label = varName;
    }

    public Boolean getFlagStart() {
        return flagStart;
    }

    public void setFlagStart(Boolean flagStart) {
        this.flagStart = flagStart;
    }
}
