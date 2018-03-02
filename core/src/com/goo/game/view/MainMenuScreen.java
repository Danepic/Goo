package com.goo.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.goo.game.utils.PathUtils;
import com.goo.game.view.world1.AdventureTimeScreen;

/**
 * Created by TIO BIGA on 12/02/2018.
 */

public class MainMenuScreen implements Screen {

    private Game game;

    private SpriteBatch batch;

    private Stage stage;

    private Image logo;
    private float rotateLogo;

    private ImageButton playButton;
    private ImageButton playOption;
    private ImageButton playExit;
    private ImageButton menu;
    private ImageButton menuDireito;
    private ImageButton menuEsquerdo;

    public MainMenuScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {

        //Batch
        batch = new SpriteBatch();

        //Var Utils
        int posFinalX = Gdx.graphics.getWidth();
        int posFinalY = Gdx.graphics.getWidth();

        int meioTelaX = Gdx.graphics.getWidth()/2;
        int meioTelaY = Gdx.graphics.getHeight()/2;

        //Sprite
        logo = PathUtils.texture("components/logo.png", 185, meioTelaY + 200, 1.70f, 1.70f);

        //Buttons
        playButton = PathUtils.textureRegion("components/play.png", meioTelaX, meioTelaY);
        playOption = PathUtils.textureRegion("components/option.png", meioTelaX - 45, 75);
        playExit = PathUtils.textureRegion("components/exit.png", meioTelaX + 45, 75);

        //Components
        menu = PathUtils.textureRegion("components/menu000.png", 0, 0);
        menuDireito = PathUtils.textureRegion("components/menu100.png", 0, 0);
        menuEsquerdo = PathUtils.textureRegion("components/menu200.png", 0, 0);

        //Stage
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(playButton); //Add the button to the stage to perform rendering and take input.
        stage.addActor(playOption); //Add the button to the stage to perform rendering and take input.
        stage.addActor(playExit); //Add the button to the stage to perform rendering and take input.
        stage.addActor(logo);
        stage.addActor(menu);
        stage.addActor(menuDireito);
        stage.addActor(menuEsquerdo);
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        //Eventos
        playButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação","Botão 'Play' tocado...");
                game.setScreen(new AdventureTimeScreen(game));
                return false;
            }
        });

        playOption.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação","Botão 'Play' tocado...");
                game.setScreen(new AdventureTimeScreen(game));
                return false;
            }
        });

        playExit.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação","Saindo do jogo...");
                Gdx.app.exit();
                return false;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        rotateLogo = 100 * delta;

        stage.getActors().get(3).setOrigin(logo.getImageWidth()/2, logo.getImageHeight()/2);
        stage.getActors().get(3).rotateBy(rotateLogo);
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui

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
        stage.dispose();
    }
}
