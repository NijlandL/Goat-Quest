package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.GoatQuest;

public class LevelButton extends Button {

    private GoatQuest goatQuest;
    private int level;

    public LevelButton(GoatQuest goatQuest, Coordinate2D initialLocation, int level) {
        super(goatQuest, initialLocation, "Level: " + level);
        this.goatQuest = goatQuest;
        this.level = level;
    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        goatQuest.setActiveScene(level+1);
    }
}
