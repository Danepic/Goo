package com.goo.game;

import com.badlogic.gdx.Game;
import com.goo.game.view.MenuScreen;

public class Application extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
