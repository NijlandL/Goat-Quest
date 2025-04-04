package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.GoatQuest;

public class NextLevelButton extends Button {

    private GoatQuest goatQuest;
    private int level;

    public NextLevelButton(GoatQuest goatQuest, Coordinate2D location) {
        super(goatQuest, location, "Next Level");
        this.goatQuest = goatQuest;
        level = goatQuest.getCurrentLevel();

    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        level++;
        goatQuest.setCurrentLevel(level);
        System.out.println("Current level: " + goatQuest.getCurrentLevel());
        goatQuest.setActiveScene(level+1);

    }
}
