package com.goo.game.components;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.goo.game.enums.PhaseType;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.PathUtils;

public class RegisterPanel extends Actor {

    private Image panel;
    private Label label;
    private Image success;
    private Image failed;
    private Image closeButton;
    private Image stars0;
    private Image stars1;
    private Image stars2;
    private Image stars3;

    private PhaseType phase;
    private Game game;

    public RegisterPanel(final Game game, final PhaseType phase) {

        this.panel = PathUtils.image("components/modalResult.png", (Gdx.graphics.getWidth()/2)-125,
                (Gdx.graphics.getHeight()/2)-75, 1.5f, 1.5f, true);
        this.panel.setVisible(false);

        this.label = FontUtils.createText(FontUtils.generateCrackManFont(), 70, 1, Color.WHITE,
                3, 3, new Color(0, 0.5f, 0, 0.75f), "Resultado", 50, 50, (Gdx.graphics.getWidth()/2) - 210,
                (Gdx.graphics.getHeight()/2) + 100);
        this.label.setVisible(false);

        this.success = PathUtils.image("components/success.png", (Gdx.graphics.getWidth()/2) + 140,
                (Gdx.graphics.getHeight()/2) + 50, 0.5f, 0.5f, true);
        this.success.setVisible(false);

        this.failed = PathUtils.image("components/fail.png", (Gdx.graphics.getWidth()/2) + 140, (Gdx.graphics.getHeight()/2) + 50,
                0.5f, 0.5f, true);
        this.failed.setVisible(false);

        this.closeButton = PathUtils.image("components/fecharOption.png", (Gdx.graphics.getWidth()/2) + 300,
                (Gdx.graphics.getHeight()/2) + 175, 1, 1, true);
        this.closeButton.setVisible(false);

        this.stars0 = PathUtils.image("components/ranking0.png", (Gdx.graphics.getWidth()/2),
                (Gdx.graphics.getHeight()/2) - 150, 1, 1, true);
        this.stars0.setVisible(false);
        this.stars1 = PathUtils.image("components/ranking1.png", (Gdx.graphics.getWidth()/2),
                (Gdx.graphics.getHeight()/2) - 150, 1, 1, true);
        this.stars1.setVisible(false);
        this.stars2 = PathUtils.image("components/ranking2.png", (Gdx.graphics.getWidth()/2),
                (Gdx.graphics.getHeight()/2) - 150, 1, 1, true);
        this.stars2.setVisible(false);
        this.stars3 = PathUtils.image("components/ranking3.png", (Gdx.graphics.getWidth()/2),
                (Gdx.graphics.getHeight()/2) - 150, 1, 1, true);
        this.stars3.setVisible(false);
    }

    public void starsResult(int currentAttempt){
        switch (currentAttempt) {
            case 1:
                this.getStars3().setVisible(true);
                break;
            case 2:
                this.getStars2().setVisible(true);
                break;
            case 3:
                this.getStars1().setVisible(true);
                break;
        }
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

    public Image getSuccess() {
        return success;
    }

    public void setSuccess(Image success) {
        this.success = success;
    }

    public Image getFailed() {
        return failed;
    }

    public void setFailed(Image failed) {
        this.failed = failed;
    }

    public Image getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Image closeButton) {
        this.closeButton = closeButton;
    }

    public Image getStars0() {
        return stars0;
    }

    public void setStars0(Image stars0) {
        this.stars0 = stars0;
    }

    public Image getStars1() {
        return stars1;
    }

    public void setStars1(Image stars1) {
        this.stars1 = stars1;
    }

    public Image getStars2() {
        return stars2;
    }

    public void setStars2(Image stars2) {
        this.stars2 = stars2;
    }

    public Image getStars3() {
        return stars3;
    }

    public void setStars3(Image stars3) {
        this.stars3 = stars3;
    }

    public PhaseType getPhase() {
        return phase;
    }

    public void setPhase(PhaseType phase) {
        this.phase = phase;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
