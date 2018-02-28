package com.goo.game.view.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by TIO BIGA on 12/02/2018.
 */

public class TextButtonTest implements Screen {

    private Game game;

    public TextButtonTest(Game game) {
        this.game = game;
    }

    private Stage stage;
    private Skin skin;

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();

        Pixmap pixmap = new Pixmap(1,1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));

        skin.add("default", new BitmapFont());

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("white", Color.GREEN);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        for (int i = 0; i < 10; i++) {
            TextButton t = new TextButton("Button" + i, skin);
            t.setX(MathUtils.random(0, Gdx.graphics.getWidth()));
            t.setY(MathUtils.random(0, Gdx.graphics.getHeight()));
            t.setWidth(MathUtils.random(50, 200));
            t.setHeight(MathUtils.random(0, 100));
            stage.addActor(t);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        Gdx.app.log("X", "FPS: " + Gdx.graphics.getFramesPerSecond());
        SpriteBatch spriteBatch = (SpriteBatch)stage.getBatch();
        Gdx.app.log("X", "render calls: " + spriteBatch.totalRenderCalls);
        spriteBatch.totalRenderCalls = 0;
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        skin.dispose();
    }
}
