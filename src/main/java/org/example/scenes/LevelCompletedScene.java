package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.GoatQuest;
import org.example.entities.buttons.Button;
import org.example.entities.buttons.MainMenuButton;
import org.example.entities.buttons.NextLevelButton;

public class LevelCompletedScene extends StaticScene {

    private GoatQuest goatQuest;

    public LevelCompletedScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.png");
        setBackgroundAudio("music/GoatQuest Song 1.mp3");

    }

    @Override
    public void setupEntities() {
        Button mainMenuButton = new MainMenuButton(goatQuest, new Coordinate2D(getWidth()/2,getHeight()/2));
        mainMenuButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(mainMenuButton);

        Button testButton = new NextLevelButton(goatQuest, new Coordinate2D(10,20));
        addEntity(testButton);

    }
}
