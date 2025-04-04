package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.GoatQuest;

public class QuitButton extends Button {

    GoatQuest goatQuest;

    public QuitButton(GoatQuest goatQuest, Coordinate2D initialLocation) {
        super(goatQuest, initialLocation, "Quit Game");
        this.goatQuest = goatQuest;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        goatQuest.quit();
    }
}
