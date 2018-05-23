package com.goo.game.view.world1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.goo.game.actors.FinnActor;
import com.goo.game.components.Component;
import com.goo.game.enums.PhaseType;
import com.goo.game.enums.StateType;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.NumericInputListenerUtils;
import com.goo.game.utils.StringInputListenerUtils;
import com.goo.game.utils.PathUtils;
import com.goo.game.view.WorldScreen;

import org.hamcrest.CoreMatchers;

import java.util.Random;

import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;


public class AdventureTimeScreen implements Screen {

    private Game game;
    private PhaseType phase;

    private Preferences prefs;

    private SpriteBatch batch;

    private NumericInputListenerUtils input;

    private Stage stage;

    private Skin skin;

    private Music bgm;

    private Image bg;

    private Texture[] finnStance;
    private Animation<Texture> finnStanceAnimation;

    private Texture[] finnJump;
    private Animation<Texture> finnJumpAnimation;

    private Texture[] finnLand;
    private Animation<Texture> finnLandAnimation;

    private Texture[] finnDancing;
    private Animation<Texture> finnDancingAnimation;

    private FinnActor finn;

    private Component var;
    private int valueVar;

    private Image resultPanel;
    private Label resultPanelLabel;

    private Label attempts;
    private int currentAttempt;
    private final int limitAttempt = 3;

    private Image back;
    private Image forward;

    private Image success;
    private Image failed;
    private Image closeButton;

    private Image stars0;
    private Image stars1;
    private Image stars2;
    private Image stars3;

    public AdventureTimeScreen(Game game) {
        this.game = game;
    }

    public AdventureTimeScreen(Game game, PhaseType phase) {
        this.game = game;
        this.phase = phase;
    }

    @Override
    public void show() {
        //Batch
        batch = new SpriteBatch();

        //Preferences
        prefs = Gdx.app.getPreferences("userPref");

        //Skin
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        //Input
        input = new NumericInputListenerUtils();

        //Animation Stance
        finnStance = new Texture[11];
        for (int i = 0; i < finnStance.length; i++){
            finnStance[i] = new Texture("chars/finn/stance"+i+".png");
        }
        finnStanceAnimation = new Animation<Texture>(0.08f, finnStance);

        //Animation Jump
        finnJump = new Texture[15];
        for (int i = 0; i < finnJump.length; i++){
            finnJump[i] = new Texture("chars/finn/jump"+i+".png");
        }
        finnJumpAnimation = new Animation<Texture>(0.08f, finnJump);

        //Animation Land
        finnLand = new Texture[4];
        for (int i = 0; i < finnLand.length; i++){
            finnLand[i] = new Texture("chars/finn/land"+i+".png");
        }
        finnLandAnimation = new Animation<Texture>(0.02f, finnLand);

        finn = new FinnActor(225, 300, 100, 100, finnStanceAnimation, finnJumpAnimation, finnLandAnimation);

        //Var Utils
        final int posFinalX = Gdx.graphics.getWidth();
        int posFinalY = Gdx.graphics.getWidth();

        int meioTelaX = Gdx.graphics.getWidth() / 2;
        int meioTelaY = Gdx.graphics.getHeight() / 2;

        Random random = new Random();

        //BG
        bg = PathUtils.image("background/01bg.png", 450, 275, 1.40f, 1.40f, true);

        //Button
        var = new Component("components/elements/var-teste.png",
                random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()));

        back = PathUtils.image("components/elements/back.png", 150, 600, 1, 1, true);
        forward = PathUtils.image("components/elements/forward.png", posFinalX - 150, 600, 1, 1, true);

        attempts = FontUtils.createText(FontUtils.generateCrackManFont(), 70, 1, Color.WHITE,
                3, 3, new Color(0, 0.5f, 0, 0.75f), currentAttempt+"/"+limitAttempt,
                50, 50, meioTelaX - 75, meioTelaY -325);

        resultPanel = PathUtils.image("components/modalResult.png", meioTelaX-125, meioTelaY-75, 1.5f, 1.5f, true);
        resultPanel.setVisible(false);

        resultPanelLabel = FontUtils.createText(FontUtils.generateCrackManFont(), 70, 1, Color.WHITE,
        3, 3, new Color(0, 0.5f, 0, 0.75f), "Resultado",
        50, 50, meioTelaX - 210, meioTelaY + 100);
        resultPanelLabel.setVisible(false);

        success = PathUtils.image("components/success.png", meioTelaX + 140, meioTelaY + 50, 0.5f, 0.5f, true);
        success.setVisible(false);
        failed = PathUtils.image("components/fail.png", meioTelaX + 140, meioTelaY + 50, 0.5f, 0.5f, true);
        failed.setVisible(false);
        closeButton = PathUtils.image("components/fecharOption.png", meioTelaX + 300, meioTelaY + 175, 1, 1, true);
        closeButton.setVisible(false);

        stars0 = PathUtils.image("components/ranking0.png", meioTelaX, meioTelaY - 150, 1, 1, true);
        stars0.setVisible(false);
        stars1 = PathUtils.image("components/ranking1.png", meioTelaX, meioTelaY - 150, 1, 1, true);
        stars1.setVisible(false);
        stars2 = PathUtils.image("components/ranking2.png", meioTelaX, meioTelaY - 150, 1, 1, true);
        stars2.setVisible(false);
        stars3 = PathUtils.image("components/ranking3.png", meioTelaX, meioTelaY - 150, 1, 1, true);
        stars3.setVisible(false);

        //Actors
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(bg);
        stage.addActor(finn);
        stage.addActor(back);
        stage.addActor(forward);
        stage.addActor(var);
        stage.addActor(resultPanel);
        stage.addActor(resultPanelLabel);
        stage.addActor(attempts);
        stage.addActor(success);
        stage.addActor(failed);
        stage.addActor(closeButton);
        stage.addActor(stars0);
        stage.addActor(stars1);
        stage.addActor(stars2);
        stage.addActor(stars3);

        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        //Eventos

        closeButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Voltando para tela de seleção de mundos...");
                game.setScreen(new WorldScreen(game, phase));
                return false;
            }
        });

        back.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Voltando para tela de seleção de mundos...");
                game.setScreen(new WorldScreen(game));
                return false;
            }
        });

        forward.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                Gdx.app.log("Ação", "Executando código");
                valueVar = (input.getValue() != null)?input.getValue():0;
                currentAttempt ++;
                attempts.setText(currentAttempt+"/"+limitAttempt);
            }
        });

        var.addListener(new ActorGestureListener(){
            @Override
            public boolean longPress(Actor actor, float x, float y) {
                Gdx.app.log("Ação", "Atribuir valor");
                Gdx.input.getTextInput(input, "Digite um NÚMERO!", "", "");
                return super.longPress(actor, x, y);
            }
        });

        var.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                var.moveBy(x - var.getWidth() / 2, y - var.getHeight() / 2);
            }
        });

        //Start Animation
        for (int i = 0; i < finnStance.length; i++) {
            finnStance[i] = new Texture("chars/finn/stance" + i + ".png");
        }

        finnStanceAnimation = new Animation<Texture>(0.08f, finnStance);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        if(finn.getState() == StateType.STANCE && finn.getX() >= 988 && currentAttempt <= 3){
            resultPanel.setVisible(true);
            resultPanelLabel.setVisible(true);
            success.setVisible(true);
            closeButton.setVisible(true);
            var.clearListeners();
            back.clearListeners();
            forward.clearListeners();
            phase = PhaseType.SECOND;

            switch (currentAttempt){
                case 1:
                    stars3.setVisible(true);
                    break;
                case 2:
                    stars2.setVisible(true);
                    break;
                case 3:
                    stars1.setVisible(true);
                    break;
            }
        }

        if(currentAttempt > 3 && finn.getX() < 988){
            resultPanel.setVisible(true);
            resultPanelLabel.setVisible(true);
            failed.setVisible(true);
            closeButton.setVisible(true);
            var.clearListeners();
            back.clearListeners();
            forward.clearListeners();
            phase = PhaseType.FIRST;
            stars0.setVisible(true);
        }

        if(valueVar > 0 && finn.getState() == StateType.STANCE && currentAttempt <= 3){
            if(finn.getX() < 988){
                valueVar--;
                finn.setState(StateType.JUMP);
            }
        }

        if(finn.getState() == StateType.RESET){
            forward.setColor(Color.WHITE);
            forward.setVisible(true);
        }

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
        batch.dispose();
        bgm.dispose();
        game.dispose();
        skin.dispose();
    }
}
