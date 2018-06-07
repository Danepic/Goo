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

public class VarNumeric extends Actor {

    private Rectangle rectangle;
    private Texture texture;
    private NumericInputListenerUtils input;
    private Label varName;

    public VarNumeric(String path, float posx, float posy, String varName) {
        this.texture = new Texture(path);

        this.varName = FontUtils.createText(FontUtils.generateCrackManFont(), 40, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, varName,
                50, 50, posx + 27, posy + 13);

        Rectangle rect = new Rectangle();
        rect.setWidth(texture.getWidth());
        rect.setHeight(texture.getHeight());

        this.rectangle = rect;
        this.setWidth(texture.getWidth());
        this.setHeight(texture.getHeight());
        this.setPosition(posx, posy);

        input = new NumericInputListenerUtils();

        this.addListener(new ActorGestureListener(){
            @Override
            public boolean longPress(Actor actor, float x, float y) {
                Gdx.app.log("Ação", "Atribuir valor");
                Gdx.input.getTextInput(input, "Digite um NÚMERO!", "", "");
                return super.longPress(actor, x, y);
            }
        });

        this.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                VarNumeric.this.moveBy(x - VarNumeric.this.getWidth() / 2, y - VarNumeric.this.getHeight() / 2);
                VarNumeric.this.getVarName().moveBy(x - VarNumeric.this.getWidth() / 2, y - VarNumeric.this.getHeight() / 2);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public NumericInputListenerUtils getInput() {
        return input;
    }

    public void setInput(NumericInputListenerUtils input) {
        this.input = input;
    }

    public Label getVarName() {
        return varName;
    }

    public void setVarName(Label varName) {
        this.varName = varName;
    }
}
