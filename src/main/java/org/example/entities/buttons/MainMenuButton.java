package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.GoatQuest;

public class MainMenuButton extends Button {

    private GoatQuest goatQuest;

    public MainMenuButton(GoatQuest goatQuest, Coordinate2D initialLocation) {
        super(goatQuest, initialLocation, "Main Menu");
        this.goatQuest = goatQuest;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        goatQuest.setActiveScene(0);
    }
}
