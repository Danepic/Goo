package com.goo.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.goo.game.view.world1.AdventureTimeScreen;

/**
 * Created by TIO BIGA on 23/11/2017.
 */
public class MenuScreen implements Screen, Input.TextInputListener {

    private Game game;

    public MenuScreen(Game game) {

        this.game = game;
    }

    private SpriteBatch batch;
    private Texture menu;
    private Texture menuEsquerdo;
    private Texture menuDireito;
    private float rotateLogo = 0;
    private Texture play;
    private Texture option;
    private Texture logo;
    private Texture exit;
    private Sprite logoSprite;

    private String username = "";
    private String password;

    private ShapeRenderer playColisao;

    float posXMenu;
    float posYMenu;

    @Override
    public void show() {
        batch = new SpriteBatch();
        menu = new Texture("components/menu000.png");
        menuEsquerdo = new Texture("components/menu100.png");
        menuDireito = new Texture("components/menu200.png");
        play = new Texture("components/play.png");
        option = new Texture("components/option.png");
        logo = new Texture("components/logo.png");
        exit = new Texture("components/exit.png");

        logoSprite = new Sprite(logo);

        posXMenu = (Gdx.graphics.getWidth()/2)-(play.getWidth()/2);
        posYMenu = (float) (Gdx.graphics.getHeight()*0.10);
        logoSprite.setPosition(55, (float) (Gdx.graphics.getHeight()*0.62));
        logoSprite.setScale((float) 1.70);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        rotateLogo = 35 * delta;

        batch.begin();

        batch.draw(menu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch.draw(menuEsquerdo, 0, 0, (float) (Gdx.graphics.getWidth() * 0.35), menuEsquerdo.getHeight());
        batch.draw(menuDireito, (float) (Gdx.graphics.getWidth() * 0.65), 0, (float) (Gdx.graphics.getWidth() * 0.35), menuDireito.getHeight());

        batch.draw(play, posXMenu - 60, Gdx.graphics.getHeight()/2 - 50 , play.getWidth()+ 120, play.getHeight()+55);
        batch.draw(exit, posXMenu - 65, (float) (Gdx.graphics.getHeight()* 0.0075), exit.getWidth()*2, exit.getHeight()*2);
        batch.draw(option, posXMenu + 65, (float) (Gdx.graphics.getHeight()* 0.0075), option.getWidth()*2, option.getHeight()*2);

        logoSprite.draw(batch);
        logoSprite.rotate(rotateLogo);

        if(Gdx.input.justTouched()){
            Gdx.app.log("TocouX",Gdx.input.getX() + " | " + (posXMenu - 60) + " - " + ((posXMenu - 60) + (play.getWidth()+120))); // Informação da locazação X da colisão do botao play
            Gdx.app.log("TocouY",Gdx.input.getY() + " | " + ((Gdx.graphics.getHeight()/2)-75) + " - " + ((Gdx.graphics.getHeight()/2)-50 + play.getHeight()+30));// Informação da locazação X da colisão do botao play
            //Se tocar no botão play
            if(Gdx.input.getX() >= (posXMenu - 60) && Gdx.input.getX() <= (posXMenu - 60) + (play.getWidth()+120)//Se X e a largura foram do tamanho do botao
                    && Gdx.input.getY() >= ((Gdx.graphics.getHeight()/2)-75) && Gdx.input.getY() <= ((Gdx.graphics.getHeight()/2)-50) + (play.getHeight()+30)){ //Se Y e a altura foram do tamanho do botao

                //Gdx.app.log("Tocou no menu","Tocou no menu");
                if(this.username != ""){
                    game.setScreen(new AdventureTimeScreen(game));
                }else{
                    Gdx.input.getTextInput(this, "Login","", "Username");
                }
            }
        }
        batch.end();




    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("Resize", "Resize");

    }

    @Override
    public void pause() {
        Gdx.app.log("Pause", "Pause");

    }

    @Override
    public void resume() {
        Gdx.app.log("Resume", "Resume");
    }

    @Override
    public void hide() {
        Gdx.app.log("Hide", "Hide");

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void input(String text) {
        this.username = text;
    }

    @Override
    public void canceled() {
        this.username = "Cancelled";
    }
}
