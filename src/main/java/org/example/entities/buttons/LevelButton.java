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

    public boolean completedLastLevel() {
        return goatQuest.getCurrentLevel() == level && goatQuest.getCurrentLevel()<=5;
    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if(completedLastLevel()) {
            goatQuest.setActiveScene(level);
            goatQuest.setCurrentLevel(level);
        } else {
            System.out.println("Level not unlocked");
        }
    }
}
