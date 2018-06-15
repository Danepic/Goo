package com.goo.game.components;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.goo.game.enums.PhaseType;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.PathUtils;
import com.goo.game.utils.StringInputListenerUtils;

import java.util.Arrays;
import java.util.List;

import mk.gdx.firebase.GdxFIRAuth;

public class LoginPanel extends Actor {

    private Image panel;
    private Image closeButton;
    private Label label;

    private Label labelEmailTxt;
    private TextField emailTxt;
    private StringInputListenerUtils emailInput;

    private Label labelPasswordTxt;
    private TextField passwordTxt;
    private StringInputListenerUtils passwordInput;

    private Label cadastrar;

    private Label loginLabel;
    private Image login;

    public LoginPanel(Skin skin) {
        emailInput = new StringInputListenerUtils();
        passwordInput = new StringInputListenerUtils();

        panel = PathUtils.image("components/modalResult.png", 400, 250,
                1.75f, 1.75f, true);
        panel.setVisible(false);

        closeButton = PathUtils.image("components/fecharOption.png", (Gdx.graphics.getWidth()/2) + 350,
                (Gdx.graphics.getHeight()/2) + 185, 1, 1, true);
        closeButton.setVisible(false);

        label = FontUtils.createText(FontUtils.generateCrackManFont(), 40, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, "Login",
                50, 50, 515, 515);
        label.setVisible(false);

        labelEmailTxt = FontUtils.createText(FontUtils.generateCrackManFont(), 40, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, "Email",
                50, 50, 250, 410);
        labelEmailTxt.setVisible(false);
        emailTxt = new TextField("", skin);
        emailTxt.setPosition(550, 400);
        emailTxt.setSize(400, 75);
        emailInput.setText("");
        emailTxt.setVisible(false);
        emailTxt.clearListeners();
        emailTxt.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.getTextInput(emailInput, "Digite seu email!", "", "Email");
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        labelPasswordTxt = FontUtils.createText(FontUtils.generateCrackManFont(), 40, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, "Password",
                50, 50, 250, 310);
        labelPasswordTxt.setVisible(false);
        passwordTxt = new TextField("", skin);
        passwordTxt.setPasswordCharacter('#');
        passwordTxt.setPasswordMode(true);
        passwordTxt.setText("");
        passwordTxt.setPosition(550, 300);
        passwordTxt.setSize(400, 75);
        passwordTxt.setVisible(false);
        passwordTxt.clearListeners();
        passwordTxt.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.getTextInput(passwordInput, "Digite sua senha!", "", "Password");
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        closeButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                passwordTxt.setVisible(false);
                labelPasswordTxt.setVisible(false);
                emailTxt.setVisible(false);
                labelEmailTxt.setVisible(false);
                label.setVisible(false);
                closeButton.setVisible(false);
                panel.setVisible(false);
                login.setVisible(false);
                loginLabel.setVisible(false);
                cadastrar.setVisible(false);
                return false;
            }
        });

        cadastrar = FontUtils.createText(FontUtils.generateCrackManFont(), 30, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, "Não tem conta? Cadastre-se!",
                500, 50, 345, 130);
        cadastrar.setVisible(false);
        cadastrar.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                passwordTxt.setVisible(false);
                labelPasswordTxt.setVisible(false);
                emailTxt.setVisible(false);
                labelEmailTxt.setVisible(false);
                label.setVisible(false);
                closeButton.setVisible(false);
                panel.setVisible(false);
                login.setVisible(false);
                loginLabel.setVisible(false);
                cadastrar.setVisible(false);
            }
        });

        login = PathUtils.image("components/button.png", (Gdx.graphics.getWidth()/2) - 150,
                (Gdx.graphics.getHeight()/2) - 130, 1.80f, 1, true);
        login.setVisible(false);

        loginLabel = FontUtils.createText(FontUtils.generateCrackManFont(), 30, 1, Color.WHITE,
                3, 3, Color.DARK_GRAY, "Já tem uma conta? Entrar!",
                50, 50, 375, 200);
        loginLabel.setVisible(false);

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

    public TextField getEmailTxt() {
        return emailTxt;
    }

    public void setEmailTxt(TextField EmailTxt) {
        this.emailTxt = EmailTxt;
    }

    public Image getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Image closeButton) {
        this.closeButton = closeButton;
    }

    public TextField getPasswordTxt() {
        return passwordTxt;
    }

    public void setPasswordTxt(TextField passwordTxt) {
        this.passwordTxt = passwordTxt;
    }

    public Label getLabelEmailTxt() {
        return labelEmailTxt;
    }

    public void setLabelEmailTxt(Label labelEmailTxt) {
        this.labelEmailTxt = labelEmailTxt;
    }

    public Label getLabelPasswordTxt() {
        return labelPasswordTxt;
    }

    public void setLabelPasswordTxt(Label labelPasswordTxt) {
        this.labelPasswordTxt = labelPasswordTxt;
    }

    public StringInputListenerUtils getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(StringInputListenerUtils EmailInput) {
        this.emailInput = EmailInput;
    }

    public StringInputListenerUtils getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(StringInputListenerUtils passwordInput) {
        this.passwordInput = passwordInput;
    }

    public Label getCadastrar() {
        return cadastrar;
    }

    public void setCadastrar(Label cadastrar) {
        this.cadastrar = cadastrar;
    }

    public Label getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(Label loginLabel) {
        this.loginLabel = loginLabel;
    }

    public Image getLogin() {
        return login;
    }

    public void setLogin(Image login) {
        this.login = login;
    }
}
