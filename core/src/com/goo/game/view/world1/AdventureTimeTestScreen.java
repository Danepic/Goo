package com.goo.game.view.world1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by TIO BIGA on 26/11/2017.
 */
public class AdventureTimeTestScreen implements Screen {
    private Game game;

    public AdventureTimeTestScreen(Game game){
        this.game = game;
    }

    private SpriteBatch batch;
    private Texture bg;
    private Texture[] finnStance;
    private Animation<Texture> animation;
    private float tempo;

    private Texture se;
    private Texture var;
    private Texture igual;
    private Texture result;
    private Texture fim;

    private Sprite seSprite;
    private Sprite varSprite;
    private Sprite igualSprite;
    private Sprite resultSprite;
    private Sprite fimSprite;

    @Override
    public void show() {
        batch = new SpriteBatch();
        bg = new Texture("background/01bg.png");
        finnStance = new Texture[11];

        se = new Texture("components/elements/se.png");
        var = new Texture("components/elements/var-teste.png");
        igual = new Texture("components/elements/igual.png");
        result = new Texture("components/elements/result-teste.png");
        fim = new Texture("components/elements/fim.png");

        seSprite = new Sprite(se);
        varSprite = new Sprite(var);
        igualSprite = new Sprite(igual);
        resultSprite = new Sprite(result);
        fimSprite = new Sprite(fim);

        seSprite.setPosition(0, Gdx.graphics.getHeight()-100);
        seSprite.setSize(se.getWidth(), se.getHeight());

        varSprite.setPosition(0, Gdx.graphics.getHeight()-300);
        varSprite.setSize(var.getWidth(), var.getHeight());

        igualSprite.setPosition(0, Gdx.graphics.getHeight()-500);
        igualSprite.setSize(igual.getWidth(), igual.getHeight());

        resultSprite.setPosition(0, Gdx.graphics.getHeight()-700);
        resultSprite.setSize(result.getWidth(), result.getHeight());

        fimSprite.setPosition(Gdx.graphics.getWidth()-fim.getWidth(), Gdx.graphics.getHeight()-400);
        fimSprite.setSize(fim.getWidth(), fim.getHeight());

        for (int i = 0; i < finnStance.length; i++){
            finnStance[i] = new Texture("chars/finn/stance"+i+".png");
        }

        animation = new Animation<Texture>(0.08f, finnStance);
    }

    @Override
    public void render(float delta) {
        tempo += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(animation.getKeyFrame(tempo, true), 180, 270, 110, 80);
        batch.draw(seSprite, seSprite.getX(), seSprite.getY(), se.getWidth(), se.getHeight());
        batch.draw(varSprite, varSprite.getX(), varSprite.getY(), var.getWidth(), var.getHeight());
        batch.draw(igualSprite, igualSprite.getX(), igualSprite.getY(), igual.getWidth(), igual.getHeight());
        batch.draw(resultSprite, resultSprite.getX(), resultSprite.getY(), result.getWidth(), result.getHeight());
        batch.draw(fimSprite, fimSprite.getX(), fimSprite.getY(), fim.getWidth(), fim.getHeight());

        if(Gdx.input.isTouched()){
            Gdx.app.log("s","a");
            Gdx.app.log("Coord",seSprite.getX() + "|" + seSprite.getWidth());
            Gdx.app.log("Coord2",seSprite.getY() + "|" + seSprite.getHeight());
            Gdx.app.log("Coord3",Gdx.input.getX() + "|" + Gdx.input.getY());
            if(Gdx.input.getX() >= seSprite.getX() && Gdx.input.getX() <= seSprite.getWidth()
                    && Gdx.input.getY() >= seSprite.getY() && Gdx.input.getY() <= seSprite.getHeight()){
                seSprite.setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            }
        }

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
