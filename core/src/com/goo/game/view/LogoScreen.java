package com.goo.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.PathUtils;

/**
 * Created by TIO BIGA on 26/11/2017.
 */

public class LogoScreen implements Screen {

    private Game game;
    private Stage stage;
    private Image logo;
    private SpriteBatch batch;

    public LogoScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {

        batch = new SpriteBatch();

        logo = PathUtils.image("components/danepic_logo.png", Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight(), 1, 1, false);

        stage = new Stage(new ScreenViewport());

        logo.addAction(Actions.sequence(Actions.fadeOut(0.001f), Actions.fadeIn(2f), Actions.delay(3f), Actions.fadeOut(2f), new Action() {
            @Override
            public boolean act(float delta) {
                Gdx.app.log("Ação", "Iniciando Menu...");
                game.setScreen(new MainMenuScreen(game));
                return false;
            }
        }));

        stage.addActor(logo);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

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
