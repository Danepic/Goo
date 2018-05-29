package com.goo.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.goo.game.utils.NumericInputListenerUtils;

public class Attempts extends Actor {

    private Rectangle rectangle;
    private Texture texture;
    private NumericInputListenerUtils input;

    public Attempts(String path, float posx, float posy) {
        this.texture = new Texture(path);

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
                Attempts.this.moveBy(x - Attempts.this.getWidth() / 2, y - Attempts.this.getHeight() / 2);
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
}
