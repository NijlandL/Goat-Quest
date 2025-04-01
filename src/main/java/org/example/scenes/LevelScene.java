package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.Scene;
import org.example.GoatQuest;
import org.example.entities.buttons.LevelButton;

public class LevelScene extends StaticScene {

    private GoatQuest goatQuest;

    public LevelScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.jpg");
    }

    @Override
    public void setupEntities() {
        var level1Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/3, getHeight()/2), 1);
        addEntity(level1Button);

        var level2Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4*2, getHeight()/2), 1);
        addEntity(level2Button);

        var level3Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4, getHeight()/2), 1);
        addEntity(level3Button);

        var level4Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/2, getHeight()/3*2), 1);
        addEntity(level4Button);

        var level5Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4*3, getHeight()/3*2), 1);
        addEntity(level5Button);
    }
}
