package com.goo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.goo.game.view.MainMenuScreen;

public class Application extends Game {

    @Override
    public void create() {
        Gdx.app.log("GOO: ", "Criando a aplicação");
        setScreen(new MainMenuScreen(this));
    }
}
