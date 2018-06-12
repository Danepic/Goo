package com.goo.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.goo.game.enums.StateType;


public class ShineActor extends Actor{

    private Texture[] stanceTexture;
    private Animation<Texture> stanceAnimation;

    private Animation[] animControl = new Animation[3];

    private Animation stance;

    private Texture currentRegion;

    float stanceTime = 0f;

    public ShineActor(float posx, float posy, float scalex, float scaley){
        //Animation Stance
        stanceTexture = new Texture[8];
        for (int i = 1; i < stanceTexture.length; i++){
            stanceTexture[i] = new Texture("chars/shine/0"+i+".png");
        }
        animControl[0] = new Animation<Texture>(0.08f, stanceTexture);

        this.setScale(scalex, scaley);
        this.setPosition(posx, posy);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //Actions
        float soloY = this.getY();
        float soloX = this.getX();

        stanceTime += delta;
        currentRegion = (Texture) stance.getKeyFrame(stanceTime, true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(currentRegion, getX(), getY());
    }

    public Texture[] getStanceTexture() {
        return stanceTexture;
    }

    public void setStanceTexture(Texture[] stanceTexture) {
        this.stanceTexture = stanceTexture;
    }

    public Animation<Texture> getStanceAnimation() {
        return stanceAnimation;
    }

    public void setStanceAnimation(Animation<Texture> stanceAnimation) {
        this.stanceAnimation = stanceAnimation;
    }

    public Animation[] getAnimControl() {
        return animControl;
    }

    public void setAnimControl(Animation[] animControl) {
        this.animControl = animControl;
    }

    public Animation getStance() {
        return stance;
    }

    public void setStance(Animation stance) {
        this.stance = stance;
    }

    public Texture getCurrentRegion() {
        return currentRegion;
    }

    public void setCurrentRegion(Texture currentRegion) {
        this.currentRegion = currentRegion;
    }
}
