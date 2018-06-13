package com.goo.game.components;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.goo.game.enums.PhaseType;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.PathUtils;

public class LoginPanel extends Actor {

    private Image panel;
    private Image closeButton;
    private Label label;
    private TextField usernameTxt;
    private TextField birthDtp;
    private TextField nicknameTxt;
    private TextField emailTxt;
    private TextField countryEnum;

    public LoginPanel(Skin skin) {
        panel = PathUtils.image("components/modalResult.png", 400, 250,
                1.75f, 1.75f, true);
        panel.setVisible(false);

        closeButton = PathUtils.image("components/fecharOption.png", (Gdx.graphics.getWidth()/2) + 300,
                (Gdx.graphics.getHeight()/2) + 175, 1, 1, true);
        closeButton.setVisible(false);

        label = FontUtils.createText(FontUtils.generateCrackManFont(), 40, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, "Login",
                50, 50, 515, 500);
        label.setVisible(false);

        usernameTxt = new TextField("Username", skin);
        usernameTxt.setPosition(0, 500);
        usernameTxt.setSize(400, 75);
        usernameTxt.setVisible(false);

        birthDtp = new TextField("Birth", skin);
        usernameTxt.setPosition(350, 100);
        birthDtp.setSize(400, 75);
        birthDtp.setVisible(false);

        nicknameTxt = new TextField("Nickname", skin);
        usernameTxt.setPosition(250, 150);
        nicknameTxt.setSize(400, 75);
        nicknameTxt.setVisible(false);

        emailTxt = new TextField("Email", skin);
        usernameTxt.setPosition(250, 100);
        emailTxt.setSize(400, 75);
        emailTxt.setVisible(false);

        countryEnum = new TextField("Country", skin);
        usernameTxt.setPosition(325, 50);
        countryEnum.setSize(400, 75);
        countryEnum.setVisible(false);
    }

    public Image getPanel() {
        return panel;
    }

    public void setPanel(Image panel) {
        this.panel = panel;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TextField getUsernameTxt() {
        return usernameTxt;
    }

    public void setUsernameTxt(TextField usernameTxt) {
        this.usernameTxt = usernameTxt;
    }

    public TextField getBirthDtp() {
        return birthDtp;
    }

    public void setBirthDtp(TextField birthDtp) {
        this.birthDtp = birthDtp;
    }

    public TextField getNicknameTxt() {
        return nicknameTxt;
    }

    public void setNicknameTxt(TextField nicknameTxt) {
        this.nicknameTxt = nicknameTxt;
    }

    public TextField getEmailTxt() {
        return emailTxt;
    }

    public void setEmailTxt(TextField emailTxt) {
        this.emailTxt = emailTxt;
    }

    public TextField getCountryEnum() {
        return countryEnum;
    }

    public void setCountryEnum(TextField countryEnum) {
        this.countryEnum = countryEnum;
    }
}
