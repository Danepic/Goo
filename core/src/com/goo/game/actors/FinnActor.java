package com.goo.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.goo.game.enums.StateType;

import javafx.scene.shape.MoveTo;


public class FinnActor extends Actor{

    private Animation stance;
    private Animation jump;
    private Animation land;
    private Animation dancing;

    private Texture currentRegion;

    private StateType state = StateType.STANCE;

    private boolean isGrounded = true;

    float stanceTime = 0f;
    float jumpTime = 0f;
    float landTime = 0f;
    int jumpCount = 0;

    public FinnActor(float posx, float posy, float scalex, float scaley, Animation... animation){
        for (int i = 0; i < animation.length; i++){
            if (i == 0){
                this.stance = animation[0];
            }
            if (i == 1){
                this.jump = animation[1];
            }
            if (i == 2){
                this.land = animation[2];
            }
            if (i == 3){
                this.dancing = animation[3];
            }
        }
        this.setScale(scalex, scaley);
        this.setPosition(posx, posy);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //Actions
        float soloY = this.getY();
        float soloX = this.getX();

        switch (state){
            case STANCE:
                stanceTime += delta;
                currentRegion = (Texture) stance.getKeyFrame(stanceTime, true);
                break;
            case JUMP:
                jumpTime += delta;
                currentRegion = (Texture) jump.getKeyFrame(jumpTime, false);

                if(jump.getKeyFrameIndex(jumpTime) > 2){
                    if (isGrounded){
                        moveBy(4, 5);
                    }
                }
                if (!isGrounded){
                    moveBy(3.5f, -5);
                    if(soloY == 340 && jumpCount == 2){
                        this.setState(StateType.LAND);
                    }
                    if(soloY == 365 && jumpCount != 2){
                        this.setState(StateType.LAND);
                    }
                }
                if(jump.getKeyFrameIndex(jumpTime) > 9){
                    isGrounded = false;
                }

                break;
            case LAND:
                isGrounded = true;
                landTime += delta;
                currentRegion = (Texture) land.getKeyFrame(landTime, false);

                if (land.isAnimationFinished(landTime)){
                    this.setState(StateType.RESET);
                }

                break;
            case DANCING:
                currentRegion = (Texture) dancing.getKeyFrame(stanceTime, true);
                break;
            case RESET:
                jumpCount += 1;
                landTime = 0;
                jumpTime = 0;
                stanceTime = 0;
                this.setState(StateType.STANCE);
                break;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(currentRegion, getX(), getY());
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

    public int getJumpCount() {
        return jumpCount;
    }

    public void setJumpCount(int jumpCount) {
        this.jumpCount = jumpCount;
    }

    public Animation getStance() {
        return stance;
    }

    public void setStance(Animation stance) {
        this.stance = stance;
    }

    public Animation getJump() {
        return jump;
    }

    public void setJump(Animation jump) {
        this.jump = jump;
    }

    public Animation getLand() {
        return land;
    }

    public void setLand(Animation land) {
        this.land = land;
    }

    public Animation getDancing() {
        return dancing;
    }

    public void setDancing(Animation dancing) {
        this.dancing = dancing;
    }

    public Texture getCurrentRegion() {
        return currentRegion;
    }

    public void setCurrentRegion(Texture currentRegion) {
        this.currentRegion = currentRegion;
    }

    public boolean isGrounded() {
        return isGrounded;
    }

    public void setGrounded(boolean grounded) {
        isGrounded = grounded;
    }
}
