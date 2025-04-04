package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.Scene;
import org.example.GoatQuest;
import org.example.entities.buttons.LevelButton;
import org.example.entities.buttons.MainMenuButton;

public class LevelScene extends StaticScene {

    private GoatQuest goatQuest;

    public LevelScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.png");
        setBackgroundAudio("music/GoatQuest Song 1.mp3");
    }

    @Override
    public void setupEntities() {

        int interval = 50;

        var level1Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4-interval, getHeight()/2), 1);
        addEntity(level1Button);

        var level2Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4*2-interval, getHeight()/2), 2);
        addEntity(level2Button);

        var level3Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4*3-interval, getHeight()/2), 3);
        addEntity(level3Button);

        var level4Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/3-interval, getHeight()/3*2), 4);
        addEntity(level4Button);

        var level5Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/3*2-interval, getHeight()/3*2), 5);
        addEntity(level5Button);

        var mainMenuButton = new MainMenuButton(goatQuest, new Coordinate2D(10,0));
        addEntity(mainMenuButton);
        }
    }
