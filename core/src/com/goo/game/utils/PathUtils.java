package com.goo.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by danilo.silva on 3/1/2018.
 */

public class PathUtils {

    public static ImageButton imageButton(String path, int posx, int posy){

        Texture button = new Texture(path);
        TextureRegion buttonRegion = new TextureRegion(button);
        TextureRegionDrawable buttonDrawable = new TextureRegionDrawable(buttonRegion);

        ImageButton img = new ImageButton(buttonDrawable);
        img.setPosition(posx - button.getWidth()/2, posy - button.getHeight()/2);

        return img;

    }

    public static ImageButton imageButton(String path, int posx, int posy, float scaleX, float scaleY){

        Texture button = new Texture(path);
        TextureRegion buttonRegion = new TextureRegion(button);
        TextureRegionDrawable buttonDrawable = new TextureRegionDrawable(buttonRegion);

        Image img = new Image(buttonDrawable);
        img.setScale(scaleX, scaleY);
        img.setPosition(posx - button.getWidth()/2, posy - button.getHeight()/2);

        ImageButton imgButton = new ImageButton(img.getDrawable());
        imgButton.setPosition(posx - button.getWidth()/2, posy - button.getHeight()/2);
        imgButton.setScale(scaleX, scaleY);

        return imgButton;

    }

    public static Image image(String path, int posx, int posy, float scaleX, float scaleY){

        Texture imgTexture = new Texture(path);
        TextureRegion imgRegion = new TextureRegion(imgTexture);
        TextureRegionDrawable imgDrawable = new TextureRegionDrawable(imgRegion);

        Image img = new Image(imgDrawable);
        img.setPosition(posx - imgTexture.getWidth()/2, posy - imgTexture.getHeight()/2);
        img.setScale(scaleX, scaleY);

        return img;

    }

    public static Sprite sprite(String path, int posx, int posy, float scale){

        Sprite sprite = new Sprite(new Texture(path));
        sprite.setPosition(posx, posy);
        sprite.setScale(scale);
        return sprite;

    }
}
