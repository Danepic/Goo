package com.goo.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class FinnActor extends Actor{

    private Animation stance;
    private Texture currentRegion;

    float time = 0f;

    public FinnActor(Animation animation, float posx, float posy, float scalex, float scaley){
        this.stance = animation;
        this.setPosition(posx, posy);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;

        currentRegion = (Texture) stance.getKeyFrame(time, true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(currentRegion, getX(), getY());
    }
}
