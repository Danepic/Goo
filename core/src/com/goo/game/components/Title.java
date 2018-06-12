package com.goo.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.NumericInputListenerUtils;

public class Title extends Actor {

    private Texture texture;
    private Label label;

    public Title(String path, float posx, float posy, String label) {
        this.texture = new Texture(path);

        this.label = FontUtils.createText(FontUtils.generateCrackManFont(), 40, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, label,
                50, 50, posx, posy);

        this.setWidth(texture.getWidth());
        this.setHeight(texture.getHeight());
        this.setPosition(posx, posy);


        this.addAction(Actions.sequence(Actions.delay(3f), Actions.moveBy(0,-100,1.5f), Actions.delay(3f), Actions.moveBy(0,100,1.5f)));
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
}
