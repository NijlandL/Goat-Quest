package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.GoatQuest;
import org.example.entities.buttons.Button;
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
    }

    @Override
    public void setupEntities() {

        int interval = 50;

        Button level1Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4-interval, getHeight()/2), 1);
        addEntity(level1Button);

        Button level2Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4*2-interval, getHeight()/2), 2);
        addEntity(level2Button);

        Button level3Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/4*3-interval, getHeight()/2), 3);
        addEntity(level3Button);

        Button level4Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/3-interval, getHeight()/3*2), 4);
        addEntity(level4Button);

        Button level5Button = new LevelButton(goatQuest, new Coordinate2D(getWidth()/3*2-interval, getHeight()/3*2), 5);
        addEntity(level5Button);

        Button mainMenuButton = new MainMenuButton(goatQuest, new Coordinate2D(10,0));
        addEntity(mainMenuButton);

        }

    }
