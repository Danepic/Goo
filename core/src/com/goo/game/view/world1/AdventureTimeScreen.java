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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.goo.game.actors.FinnActor;
import com.goo.game.bgs.GrasslandBG;
import com.goo.game.components.Attempts;
import com.goo.game.components.Back;
import com.goo.game.components.Forward;
import com.goo.game.components.ResultPanel;
import com.goo.game.components.Title;
import com.goo.game.components.VarNumeric;
import com.goo.game.enums.PhaseType;
import com.goo.game.enums.StateType;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.PathUtils;
import com.goo.game.utils.StageUtils;
import com.goo.game.view.WorldScreen;

import java.util.Random;


public class AdventureTimeScreen implements Screen {

    private Game game;
    private PhaseType phase = PhaseType.FIRST;

    private Preferences prefs;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private Music bgm;
    private GrasslandBG bg;
    private FinnActor finn;
    private Title title;
    private VarNumeric varNumeric;
    private int valueVar;
    private Attempts attempts;
    private Back back;
    private Forward forward;
    private ResultPanel resultPanel;

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

        finn = new FinnActor(225, 300, 100, 100);

        //VarNumeric Utils
        final int posFinalX = Gdx.graphics.getWidth();
        int posFinalY = Gdx.graphics.getWidth();

        int meioTelaX = Gdx.graphics.getWidth() / 2;
        int meioTelaY = Gdx.graphics.getHeight() / 2;

        Random random = new Random();

        //BG
        bg = new GrasslandBG();

        //Button
        title = new Title("components/elements/title.png", meioTelaX - 300, Gdx.graphics.getHeight(), "Atribuição de valor");

        varNumeric = new VarNumeric("components/elements/var.png",
                random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()), "PULAR");

        back = new Back(game);
        forward = new Forward();

        attempts = new Attempts(3);

        resultPanel = new ResultPanel(game, phase);

        //Actors
        stage = StageUtils.stageBuilder(bg.getImage(), finn, back.getImage(), forward.getImage(), varNumeric,
                varNumeric.getVarName(), resultPanel.getPanel(), resultPanel.getLabel(), attempts.getAttempts(),
                resultPanel.getSuccess(), resultPanel.getFailed(), resultPanel.getCloseButton(), resultPanel.getStars0(),
                resultPanel.getStars1(), resultPanel.getStars2(), resultPanel.getStars3(), title, title.getLabel());

        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        //Eventos interativos no Stage
        forward.getImage().addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                valueVar = (varNumeric.getInput().getValue() != null)? varNumeric.getInput().getValue():0;
                attempts.currentAttempt ++;
                attempts.getAttempts().setText(attempts.currentAttempt+"/"+attempts.getLimitAttempt());
            }
        });

        resultPanel.getCloseButton().addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Voltando para tela de seleção de mundos...");
                game.setScreen(new WorldScreen(game, phase));
                return false;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        if(finn.getState() == StateType.STANCE && finn.getX() >= 950 && attempts.currentAttempt <= 3){
            resultPanel.getPanel().setVisible(true);
            resultPanel.getLabel().setVisible(true);
            resultPanel.getSuccess().setVisible(true);
            resultPanel.getCloseButton().setVisible(true);
            varNumeric.clearListeners();
            back.getImage().clearListeners();
            forward.getImage().clearListeners();
            phase = PhaseType.SECOND;

            resultPanel.starsResult(attempts.currentAttempt);
        }

        if(attempts.currentAttempt > 3 && finn.getX() < 950){
            resultPanel.getPanel().setVisible(true);
            resultPanel.getLabel().setVisible(true);
            resultPanel.getFailed().setVisible(true);
            resultPanel.getCloseButton().setVisible(true);
            varNumeric.clearListeners();
            back.getImage().clearListeners();
            forward.getImage().clearListeners();
            phase = PhaseType.FIRST;
            resultPanel.getStars0().setVisible(true);
        }

        if(valueVar > 0 && finn.getState() == StateType.STANCE && attempts.currentAttempt <= 3){
            if(finn.getX() < 950){
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
