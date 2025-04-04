package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.GoatQuest;

public class RetryLevelButton extends Button {

    private GoatQuest goatQuest;

    public RetryLevelButton(GoatQuest goatQuest, Coordinate2D initialLocation) {
        super(goatQuest, initialLocation, "Retry Level");
        this.goatQuest = goatQuest;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        goatQuest.setActiveScene(goatQuest.getCurrentLevel()+1);
    }
}
