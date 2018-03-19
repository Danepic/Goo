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
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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

    private Image menu;
    private Image menuMirror;
    private float speedMenu;

    private Image menuDireito;
    private Image menuEsquerdo;
    private Image logo;
    private float rotateLogo;

    private Image playButton;
    private Image playOption;
    private Image playExit;

    public MainMenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {

        //Batch
        batch = new SpriteBatch();

        //Var Utils
        int posFinalX = Gdx.graphics.getWidth();
        int posFinalY = Gdx.graphics.getWidth();

        int meioTelaX = Gdx.graphics.getWidth() / 2;
        int meioTelaY = Gdx.graphics.getHeight() / 2;

        //Sprite
        logo = PathUtils.image("components/logo.png", 185, meioTelaY + 200, 1.70f, 1.70f);

        //Buttons
        playButton = PathUtils.image("components/play.png", meioTelaX-100, meioTelaY, 2, 2);
        playOption = PathUtils.image("components/option.png", meioTelaX - 100, 75, 2, 2);
        playExit = PathUtils.image("components/exit.png", meioTelaX + 25, 75, 2, 2);

        //Components
        menu = PathUtils.image("components/menu000.png", 0, 215, 2, 2);
        menuMirror = PathUtils.image("components/menu000.png", 0, 215, 2, 2);
        menuEsquerdo = PathUtils.image("components/menu100.png", 258, 430, 1, 0.839f);
        menuDireito = PathUtils.image("components/menu200.png", 925, 430, 1, 0.839f);

        //Stage
        //Actors
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui

        stage.addActor(menuMirror);//MenuAnim - Mirror
        stage.getActors().get(0).setX(0 - 2400);
        stage.addActor(menu);//MenuAnim
        stage.getActors().get(1).setX(0);

        stage.addActor(playButton); //Add the button to the stage to perform rendering and take input.
        stage.addActor(playOption); //Add the button to the stage to perform rendering and take input.
        stage.addActor(playExit); //Add the button to the stage to perform rendering and take input.
        stage.addActor(menuDireito);
        stage.addActor(menuEsquerdo);
        stage.addActor(logo);

        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        //Eventos
        playButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Botão 'Play' tocado...");
                game.setScreen(new AdventureTimeScreen(game));
                return false;
            }
        });

        playOption.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Botão 'Play' tocado...");
                game.setScreen(new AdventureTimeScreen(game));
                return false;
            }
        });

        playExit.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Saindo do jogo...");
                Gdx.app.exit();
                return false;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        //Definição apartir do delta
        rotateLogo = 100 * delta;
        speedMenu = 100 * delta;

        //Efeito de transição do menu
        stage.getActors().get(0).moveBy(speedMenu, menu.getY());
        stage.getActors().get(1).moveBy(speedMenu, menu.getY());

        //Rotação do Logo
        stage.getActors().get(7).setOrigin(logo.getImageWidth() / 2, logo.getImageHeight() / 2);
        stage.getActors().get(7).rotateBy(rotateLogo);

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
