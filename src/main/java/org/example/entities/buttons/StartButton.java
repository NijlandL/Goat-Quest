package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.GoatQuest;

public class StartButton extends Button {

    GoatQuest goatQuest;

    public StartButton(GoatQuest goatQuest, Coordinate2D initialLocation) {
        super(goatQuest, initialLocation, "Start Game");
        this.goatQuest = goatQuest;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        goatQuest.setActiveScene(goatQuest.getLEVELSCENE());
    }
}
