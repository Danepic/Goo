package com.goo.game.components;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.goo.game.enums.PhaseType;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.PathUtils;

public class LoginPanel extends Actor {

    private Image panel;
    private Label label;
    private TextField usernameTxt;
    private TextField birthDtp;
    private TextField nicknameTxt;
    private TextField emailTxt;
    private TextField countryEnum;

    private PhaseType phase;
    private Game game;

    public LoginPanel(final Game game, final PhaseType phase) {


    }


}
