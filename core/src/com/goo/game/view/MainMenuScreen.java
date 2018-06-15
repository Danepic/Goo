package com.goo.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.goo.game.components.LoginPanel;
import com.goo.game.components.Title;
import com.goo.game.components.Toast;
import com.goo.game.model.User;
import com.goo.game.utils.PathUtils;
import com.goo.game.utils.StyleUtils;

import java.util.Random;

import mk.gdx.firebase.GdxFIRApp;
import mk.gdx.firebase.GdxFIRAuth;
import mk.gdx.firebase.auth.GdxFirebaseUser;
import mk.gdx.firebase.callbacks.AuthCallback;

public class MainMenuScreen implements Screen {

    private Game game;

    private GdxFIRApp app;

    private Preferences prefs;

    private Music bgm;

    private Skin skin;

    private Float volume;

    private SpriteBatch batch;

    private Stage stage;

    private Image option;
    private Slider slider;
    private Image optionClose;
    private Image optionReturn;

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

    private Toast toast;
    private String message = "---";

    private Image registerModal;
    private LoginPanel loginModal;

    ////////////////////////////////
    int posFinalX;
    int posFinalY;
    int meioTelaX;
    int meioTelaY;

    public MainMenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {

        GdxFIRApp.instance().configure();

        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        //Preferences
        prefs = Gdx.app.getPreferences("userPref");

        Gdx.app.log("Preferences", prefs.getFloat("Volume") + " " + prefs.getString("Language") + " " + prefs.getBoolean("User", false));

        //Batch
        batch = new SpriteBatch();

        //VarNumeric Utils
        posFinalX = Gdx.graphics.getWidth();
        posFinalY = Gdx.graphics.getWidth();

        meioTelaX = Gdx.graphics.getWidth() / 2;
        meioTelaY = Gdx.graphics.getHeight() / 2;

        //Sprite
        logo = PathUtils.image("components/logo.png", 185, meioTelaY + 200, 1.70f, 1.70f, true);

        //Msg
        toast = new Toast("components/toast.png", meioTelaX - 300, Gdx.graphics.getHeight(), message);

        //Buttons
        playButton = PathUtils.image("components/play.png", meioTelaX - 100, meioTelaY, 2, 2, true);
        playOption = PathUtils.image("components/option.png", meioTelaX - 100, 75, 2, 2, true);
        playExit = PathUtils.image("components/exit.png", meioTelaX + 25, 75, 2, 2, true);
        //Components
        Random randomBG = new Random();
        int randomValue = randomBG.nextInt(3);

        //Register
        registerModal = PathUtils.image("components/modalResult.png", meioTelaX + 20, meioTelaY, 0.95f, 0.95f, true);
        loginModal = new LoginPanel(skin);

        //Options
        option = PathUtils.image("components/modalOption.png", meioTelaX + 20, meioTelaY, 0.95f, 0.95f, true);
        slider = PathUtils.slider("components/sliderTex.png", "components/sliderKnobTex.png",
                meioTelaX, meioTelaY + 60, 1, 1);
        final SelectBox selectBox = StyleUtils.selectBoxStyleLanguage(skin, meioTelaX, meioTelaY - 85);
        optionClose = PathUtils.image("components/fecharOption.png", meioTelaX + 380, 570, 1, 1, true);
        optionReturn = PathUtils.image("components/voltarOption.png", meioTelaX , 175, 1, 1, true);

        menu = PathUtils.image("components/menu0"+randomValue+"0.png", 0, 215, 2, 2, false);
        menuMirror = PathUtils.image("components/menu0"+randomValue+"0.png", 0, 215, 2, 2, true);
        menuEsquerdo = PathUtils.image("components/menu100.png", 258, 430, 1, 0.839f, true);
        menuDireito = PathUtils.image("components/menu200.png", 925, 430, 1, 0.839f, true);

        //Stage
        //Actors
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui

        stage.addActor(menuMirror);//MenuAnim - Mirror
        stage.getActors().get(0).setX(-3580);
        stage.addActor(menu);//MenuAnim
        stage.getActors().get(1).setX(-1194);

        stage.addActor(playButton); //Add the button to the stage to perform rendering and take input.
        stage.addActor(playOption); //Add the button to the stage to perform rendering and take input.
        stage.addActor(playExit); //Add the button to the stage to perform rendering and take input.
        stage.addActor(menuDireito);
        stage.addActor(menuEsquerdo);
        stage.addActor(logo);
        stage.addActor(option);
        stage.addActor(slider);
        stage.addActor(selectBox);
        stage.addActor(optionClose);
        stage.addActor(optionReturn);
        stage.addActor(registerModal);
        stage.addActor(loginModal.getPanel());
        stage.addActor(loginModal.getLabel());
        stage.addActor(loginModal.getPasswordTxt());
        stage.addActor(loginModal.getLabelPasswordTxt());
        stage.addActor(loginModal.getEmailTxt());
        stage.addActor(loginModal.getLabelEmailTxt());
        stage.addActor(loginModal.getCloseButton());
        stage.addActor(loginModal.getLogin());
        stage.addActor(loginModal.getLoginLabel());
        stage.addActor(loginModal.getCadastrar());
        stage.addActor(toast);
        stage.addActor(toast.getLabel());

        stage.getActors().get(8).setVisible(false);
        stage.getActors().get(9).setVisible(false);
        stage.getActors().get(10).setVisible(false);
        stage.getActors().get(11).setVisible(false);
        stage.getActors().get(12).setVisible(false);
        registerModal.setVisible(false);

        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        if(!prefs.contains("Volume")){
            volume = slider.getValue();
        }else{
            volume = prefs.getFloat("Volume", 50);
        }
        slider.setValue(volume);

        //BG
        bgm = Gdx.audio.newMusic(Gdx.files.internal("musics/main_bg.mp3"));
        bgm.setVolume(volume/100);
        bgm.setLooping(true);
        bgm.play();

        //Eventos
        playButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(prefs.getBoolean("User") == true){
                    Gdx.app.log("Ação", "Botão 'Play' tocado...");
                    game.setScreen(new WorldScreen(game, bgm));
                }else{
                    loginModal.getPanel().setVisible(true);
                    loginModal.getLabel().setVisible(true);
                    loginModal.getPasswordTxt().setVisible(true);
                    loginModal.getEmailTxt().setVisible(true);
                    loginModal.getLabelPasswordTxt().setVisible(true);
                    loginModal.getLabelEmailTxt().setVisible(true);
                    loginModal.getCloseButton().setVisible(true);
                    loginModal.getLogin().setVisible(true);
                    loginModal.getLoginLabel().setVisible(true);
                    loginModal.getCadastrar().setVisible(true);
                }
                return false;
            }
        });

        playOption.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Botão 'Play' tocado...");
                stage.getActors().get(8).setVisible(true);
                stage.getActors().get(9).setVisible(true);
                stage.getActors().get(10).setVisible(true);
                stage.getActors().get(11).setVisible(true);
                stage.getActors().get(12).setVisible(true);
                return false;
            }
        });

        optionClose.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                slider.setValue(volume);
                selectBox.setSelected("English");
                stage.getActors().get(8).setVisible(false);
                stage.getActors().get(9).setVisible(false);
                stage.getActors().get(10).setVisible(false);
                stage.getActors().get(11).setVisible(false);
                stage.getActors().get(12).setVisible(false);
                return false;
            }
        });

        optionReturn.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                stage.getActors().get(8).setVisible(false);
                stage.getActors().get(9).setVisible(false);
                stage.getActors().get(10).setVisible(false);
                stage.getActors().get(11).setVisible(false);
                stage.getActors().get(12).setVisible(false);

                prefs.putString("Language", selectBox.getSelected().toString());
                prefs.putFloat("Volume", volume);
                Gdx.app.log("DB", "Configurações gravadas...");

                prefs.flush();
                super.touchUp(event, x, y, pointer, button);
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

        slider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                volume = slider.getValue();
                bgm.setVolume(volume/100);
                Gdx.app.log("Teste", "VOLUME: " + volume);
                return false;
            }
        });

        selectBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("Teste","Linguagem selecionada: " + selectBox.getSelected());
            }
        });

        loginModal.getLogin().addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                User user = new User();
                user.setEmail(loginModal.getEmailTxt().getText());
                user.setPassword(loginModal.getPasswordTxt().getText());
                GdxFIRAuth.instance().signInWithEmailAndPassword(user.getEmail(), user.getPassword().toCharArray(), new AuthCallback() {
                    @Override
                    public void onSuccess(GdxFirebaseUser user) {
                        prefs.putBoolean("User", true).flush();
                        Gdx.app.log("Info","Usuario: " + user.getUserInfo().getEmail() + " logado: " + prefs.getBoolean("User"));
                        toast.setFlagStart(true);
                        message = "Conectado com Sucesso!";
                        toast.getLabel().setText(message);
                        loginModal.getCloseButton().setVisible(false);
                        loginModal.getEmailTxt().setVisible(false);
                        loginModal.getPasswordTxt().setVisible(false);
                        loginModal.getCadastrar().setVisible(false);
                        loginModal.getLabel().setVisible(false);
                        loginModal.getLabelEmailTxt().setVisible(false);
                        loginModal.getLabelPasswordTxt().setVisible(false);
                        loginModal.getLoginLabel().setVisible(false);
                        loginModal.getLogin().setVisible(false);
                        loginModal.getPanel().setVisible(false);
                    }

                    @Override
                    public void onFail(Exception e) {
                        Gdx.app.log("Error", e.getMessage());
                        toast.setFlagStart(true);
                        message = "Falha ao conectar-se! ";
                        toast.getLabel().setText(message);
                        loginModal.getCloseButton().setVisible(false);
                        loginModal.getEmailTxt().setVisible(false);
                        loginModal.getPasswordTxt().setVisible(false);
                        loginModal.getCadastrar().setVisible(false);
                        loginModal.getLabel().setVisible(false);
                        loginModal.getLabelEmailTxt().setVisible(false);
                        loginModal.getLabelPasswordTxt().setVisible(false);
                        loginModal.getLoginLabel().setVisible(false);
                        loginModal.getLogin().setVisible(false);
                        loginModal.getPanel().setVisible(false);
                    }
                });
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
        speedMenu = 400 * delta;

        //Login
        if(loginModal.getPasswordInput().getText() != null && !loginModal.getPasswordInput().getText().isEmpty()){
            loginModal.getPasswordTxt().setText(loginModal.getPasswordInput().getText());
        }
        if(loginModal.getEmailInput().getText() != null && !loginModal.getEmailInput().getText().isEmpty()){
            loginModal.getEmailTxt().setText(loginModal.getEmailInput().getText());
        }

        //Toast
        if(toast.getFlagStart()){
            this.toast.addAction(Actions.sequence(Actions.delay(0.1f), Actions.moveBy(0,-100,0.5f), Actions.delay(2f), Actions.moveBy(0,100,0.5f)));
            toast.setFlagStart(false);
        }

        //Efeito de transição do menu
        stage.getActors().get(0).moveBy(speedMenu, menu.getY());
        if (stage.getActors().get(0).getX() > Gdx.graphics.getWidth()) {
            Gdx.app.log("IMG0", ">RESET");
            stage.getActors().get(1).setX(-1194);
            stage.getActors().get(0).setX(-3570);
        }

        stage.getActors().get(1).moveBy(speedMenu, menu.getY());
        if (stage.getActors().get(1).getX() > Gdx.graphics.getWidth()) {
            Gdx.app.log("IMG1", ">RESET");
            stage.getActors().get(0).setX(-1194);
            stage.getActors().get(1).setX(-3570);
        }

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
        bgm.dispose();
        stage.dispose();
        game.dispose();
        batch.dispose();
        skin.dispose();
    }
}
