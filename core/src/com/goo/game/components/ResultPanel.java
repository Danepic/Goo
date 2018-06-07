package com.goo.game.components;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.goo.game.enums.PhaseType;
import com.goo.game.utils.FontUtils;
import com.goo.game.utils.NumericInputListenerUtils;
import com.goo.game.utils.PathUtils;
import com.goo.game.view.WorldScreen;

public class ResultPanel extends Actor {

    private Image panel;
    private Label label;
    private Image success;
    private Image failed;
    private Image closeButton;

    private PhaseType phase;
    private Game game;

    public ResultPanel(final Game game, final PhaseType phase) {

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
}
