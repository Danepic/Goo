package com.goo.game.view.world1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.goo.game.utils.PathUtils;

import java.util.Random;


public class AdventureTimeScreen implements Screen {

    private Game game;

    private SpriteBatch batch;

    private Stage stage;

    private Skin skin;

    private Music bgm;

    private Image bg;

    private Texture[] finnStance;
    private Animation<Texture> animation;
    private float tempo;

    private Image se;
    private Image var;
    private Image igual;
    private Image result;
    private Image fim;

    public AdventureTimeScreen(Game game, Music bgm) {
        this.game = game;
        this.bgm = bgm;
    }

    @Override
    public void show() {
        //Batch
        batch = new SpriteBatch();

        //Skin
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        //Animation
        finnStance = new Texture[11];

        //Var Utils
        int posFinalX = Gdx.graphics.getWidth();
        int posFinalY = Gdx.graphics.getWidth();

        int meioTelaX = Gdx.graphics.getWidth() / 2;
        int meioTelaY = Gdx.graphics.getHeight() / 2;

        Random random = new Random();

        //BG
        bg = PathUtils.image("background/01bg.png", 450, 275, 1.40f, 1.40f, true);

        //Button
        se = PathUtils.image("components/elements/se.png", random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()), 1, 1, true);
        var = PathUtils.image("components/elements/var-teste.png", random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()), 1, 1, true);
        igual = PathUtils.image("components/elements/igual.png", random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()), 1, 1, true);
        result = PathUtils.image("components/elements/result-teste.png", random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()), 1, 1, true);
        fim = PathUtils.image("components/elements/fim.png", random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()), 1, 1, true);

        //Actors
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(bg);
        stage.addActor(se);
        stage.addActor(var);
        stage.addActor(igual);
        stage.addActor(result);
        stage.addActor(fim);

        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        //Eventos
        se.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                se.moveBy(x - se.getWidth() / 2, y - se.getHeight() / 2);
            }
        });
        var.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                var.moveBy(x - se.getWidth() / 2, y - se.getHeight() / 2);
            }
        });
        igual.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                igual.moveBy(x - se.getWidth() / 2, y - se.getHeight() / 2);
            }
        });
        result.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                result.moveBy(x - se.getWidth() / 2, y - se.getHeight() / 2);
            }
        });
        fim.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                fim.moveBy(x - se.getWidth() / 2, y - se.getHeight() / 2);
            }
        });

        //Start Animation
        for (int i = 0; i < finnStance.length; i++) {
            finnStance[i] = new Texture("chars/finn/stance" + i + ".png");
        }

        animation = new Animation<Texture>(0.08f, finnStance);
    }

    @Override
    public void render(float delta) {
        tempo += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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

    }
}
