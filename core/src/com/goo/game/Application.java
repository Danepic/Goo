package com.goo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.goo.game.view.MainMenuScreen;
import com.goo.game.view.MenuScreen;
import com.goo.game.view.test.DragAndDropTest;
import com.goo.game.view.test.ImageTest;
import com.goo.game.view.test.TextButtonTest;
import com.goo.game.view.test.UISimpleTest;

public class Application extends Game {

	@Override
	public void create() {
        Gdx.app.log("GOO: ", "Criando a aplicação");
        setScreen(new MainMenuScreen(this));
	}
}
