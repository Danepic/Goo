package com.goo.game.components;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.goo.game.utils.PathUtils;
import com.goo.game.view.MainMenuScreen;
import com.goo.game.view.WorldScreen;

public class Logout extends Actor {

    private Image image;

    private Preferences prefs;

    public Logout(final Game game) {
        this.image = PathUtils.image("components/elements/back.png", 150, 600, 1, 1, true);

        //Preferences
        prefs = Gdx.app.getPreferences("userPref");

        image.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Gdx.app.log("Ação", "Voltando para tela de seleção de mundos...");
                prefs.putBoolean("User", false).flush();
                game.setScreen(new MainMenuScreen(game));
                return false;
            }
        });
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
