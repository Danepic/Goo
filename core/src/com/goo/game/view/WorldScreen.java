package com.goo.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.goo.game.enums.PhaseType;
import com.goo.game.utils.PathUtils;
import com.goo.game.view.world1.AdventureTimeScreen;

public class WorldScreen implements Screen {

    private Game game;
    private PhaseType phase = PhaseType.FIRST;

    private Preferences prefs;

    private Music bgm;

    private Skin skin;

    private SpriteBatch batch;

    private Stage stage;

    private Image bg;

    private Image tutorialWorld;
    private Image tutorialWorldPhase1;
    private Image tutorialWorldPhase2;
    private Image tutorialWorldPhase3;
    private Image tutorialWorldPhase4;
    private Image tutorialWorldPhase5;
    private Image tutorialWorldPhase6;
    private Image tutorialWorldPhase7;
    private Image tutorialWorldPhase8;

    private float speedWorld;
    private float yWorld;
    private float moveWorld;

    ////////////////////////////////
    int posFinalX;
    int posFinalY;
    int meioTelaX;
    int meioTelaY;

    public WorldScreen(Game game, Music bgm) {
        this.game = game;
        this.bgm = bgm;
    }

    public WorldScreen(Game game) {
        this.game = game;
    }

    public WorldScreen(Game game, PhaseType phase) {
        this.game = game;
        this.phase = phase;
    }

    @Override
    public void show() {

        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        if (bgm != null) {
            bgm.stop();
        }

        //Preferences
        prefs = Gdx.app.getPreferences("userPref");

        //Batch
        batch = new SpriteBatch();

        //VarNumeric Utils
        posFinalX = Gdx.graphics.getWidth();
        posFinalY = Gdx.graphics.getWidth();

        meioTelaX = Gdx.graphics.getWidth() / 2;
        meioTelaY = Gdx.graphics.getHeight() / 2;

        //Sprite
        bg = PathUtils.image("components/worldScreen.png", 0, 0, 1.90f, 1.75f, false);
        tutorialWorld = PathUtils.image("components/worlds/tutorial.png", meioTelaX, meioTelaY, 1, 1, true);

        tutorialWorldPhase1 = PathUtils.image("components/worlds/phaseOne.png", 250, meioTelaY + 150, 0.75f, 0.75f, true);
        tutorialWorldPhase1.setVisible(false);
        tutorialWorldPhase1.setColor(Color.DARK_GRAY);

        tutorialWorldPhase2 = PathUtils.image("components/worlds/phaseTwo.png", 500, meioTelaY + 150, 0.75f, 0.75f, true);
        tutorialWorldPhase2.setVisible(false);
        tutorialWorldPhase2.setColor(Color.DARK_GRAY);

        tutorialWorldPhase3 = PathUtils.image("components/worlds/phaseThree.png", 750, meioTelaY + 150, 0.75f, 0.75f, true);
        tutorialWorldPhase3.setVisible(false);
        tutorialWorldPhase3.setColor(Color.DARK_GRAY);

        tutorialWorldPhase4 = PathUtils.image("components/worlds/phaseFour.png", 1000, meioTelaY + 150, 0.75f, 0.75f, true);
        tutorialWorldPhase4.setVisible(false);
        tutorialWorldPhase4.setColor(Color.DARK_GRAY);

        tutorialWorldPhase5 = PathUtils.image("components/worlds/phaseFive.png", 250, meioTelaY - 50, 0.75f, 0.75f, true);
        tutorialWorldPhase5.setVisible(false);
        tutorialWorldPhase5.setColor(Color.DARK_GRAY);

        tutorialWorldPhase6 = PathUtils.image("components/worlds/phaseSix.png", 500, meioTelaY - 50, 0.75f, 0.75f, true);
        tutorialWorldPhase6.setVisible(false);
        tutorialWorldPhase6.setColor(Color.DARK_GRAY);

        tutorialWorldPhase7 = PathUtils.image("components/worlds/phaseSeven.png", 750, meioTelaY - 50, 0.75f, 0.75f, true);
        tutorialWorldPhase7.setVisible(false);
        tutorialWorldPhase7.setColor(Color.DARK_GRAY);

        tutorialWorldPhase8 = PathUtils.image("components/worlds/phaseEight.png", 1000, meioTelaY - 50, 0.75f, 0.75f, true);
        tutorialWorldPhase8.setVisible(false);
        tutorialWorldPhase8.setColor(Color.DARK_GRAY);

        switch (phase) {
            case FIRST:
                tutorialWorldPhase1.setColor(Color.WHITE);
                break;
            case SECOND:
                tutorialWorldPhase1.setColor(Color.WHITE);
                tutorialWorldPhase2.setColor(Color.WHITE);
                break;
            case THIRD:
                tutorialWorldPhase1.setColor(Color.WHITE);
                tutorialWorldPhase2.setColor(Color.WHITE);
                tutorialWorldPhase3.setColor(Color.WHITE);
                break;
            case FOURTH:
                tutorialWorldPhase1.setColor(Color.WHITE);
                tutorialWorldPhase2.setColor(Color.WHITE);
                tutorialWorldPhase3.setColor(Color.WHITE);
                tutorialWorldPhase4.setColor(Color.WHITE);
                break;
            case FIFTH:
                tutorialWorldPhase1.setColor(Color.WHITE);
                tutorialWorldPhase2.setColor(Color.WHITE);
                tutorialWorldPhase3.setColor(Color.WHITE);
                tutorialWorldPhase4.setColor(Color.WHITE);
                tutorialWorldPhase5.setColor(Color.WHITE);
                break;
            case SIXTH:
                tutorialWorldPhase1.setColor(Color.WHITE);
                tutorialWorldPhase2.setColor(Color.WHITE);
                tutorialWorldPhase3.setColor(Color.WHITE);
                tutorialWorldPhase4.setColor(Color.WHITE);
                tutorialWorldPhase5.setColor(Color.WHITE);
                tutorialWorldPhase6.setColor(Color.WHITE);
                break;
            case SEVENTH:
                tutorialWorldPhase1.setColor(Color.WHITE);
                tutorialWorldPhase2.setColor(Color.WHITE);
                tutorialWorldPhase3.setColor(Color.WHITE);
                tutorialWorldPhase4.setColor(Color.WHITE);
                tutorialWorldPhase5.setColor(Color.WHITE);
                tutorialWorldPhase6.setColor(Color.WHITE);
                tutorialWorldPhase7.setColor(Color.WHITE);
                break;
            case EIGHTTH:
                tutorialWorldPhase1.setColor(Color.WHITE);
                tutorialWorldPhase2.setColor(Color.WHITE);
                tutorialWorldPhase3.setColor(Color.WHITE);
                tutorialWorldPhase4.setColor(Color.WHITE);
                tutorialWorldPhase5.setColor(Color.WHITE);
                tutorialWorldPhase6.setColor(Color.WHITE);
                tutorialWorldPhase7.setColor(Color.WHITE);
                tutorialWorldPhase8.setColor(Color.WHITE);
                break;
        }

        yWorld = tutorialWorld.getY();
        moveWorld = -0.5f;

        //Stage
        //Actors
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui

        stage.addActor(bg);
        stage.addActor(tutorialWorld);
        stage.addActor(tutorialWorldPhase1);
        stage.addActor(tutorialWorldPhase2);
        stage.addActor(tutorialWorldPhase3);
        stage.addActor(tutorialWorldPhase4);
        stage.addActor(tutorialWorldPhase5);
        stage.addActor(tutorialWorldPhase6);
        stage.addActor(tutorialWorldPhase7);
        stage.addActor(tutorialWorldPhase8);

        Gdx.input.setInputProcessor(stage);

        //Eventos
        tutorialWorld.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Ação", "Tutorial selecionado...");
                tutorialWorld.setVisible(false);
                tutorialWorldPhase1.setVisible(true);
                tutorialWorldPhase2.setVisible(true);
                tutorialWorldPhase3.setVisible(true);
                tutorialWorldPhase4.setVisible(true);
                tutorialWorldPhase5.setVisible(true);
                tutorialWorldPhase6.setVisible(true);
                tutorialWorldPhase7.setVisible(true);
                tutorialWorldPhase8.setVisible(true);
            }
        });

        tutorialWorldPhase1.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Ação", "Fase 1 selecionada...");
                game.setScreen(new AdventureTimeScreen(game));
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Definição apartir do delta
        speedWorld = 1 * delta;

        stage.getActors().get(1).moveBy(0, moveWorld);

        if (stage.getActors().get(1).getY() > (yWorld + 5)) {
            moveWorld = -0.5f;
        }
        if (stage.getActors().get(1).getY() < (yWorld - 5)) {
            moveWorld = 0.5f;
        }

        batch.begin();
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
        bgm.dispose();
        stage.dispose();
        game.dispose();
        batch.dispose();
        skin.dispose();
    }
}
