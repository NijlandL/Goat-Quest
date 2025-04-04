package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.GoatQuest;
import org.example.entities.buttons.Button;
import org.example.entities.buttons.MainMenuButton;
import org.example.entities.buttons.NextLevelButton;
import org.example.text.LevelCompletedText;

public class LevelCompletedScene extends StaticScene {

    private GoatQuest goatQuest;

    public LevelCompletedScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.png");
    }

    @Override
    public void setupEntities() {
        Button mainMenuButton = new MainMenuButton(goatQuest, new Coordinate2D(getWidth()/2,getHeight()/2));
        mainMenuButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(mainMenuButton);

        Button NextLevelButton = new NextLevelButton(goatQuest, new Coordinate2D(getWidth()/2,getHeight()/3*2));
        NextLevelButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(NextLevelButton);

        var LevelCompleteText = new LevelCompletedText(new Coordinate2D(getWidth()/2,getHeight()/3));
        LevelCompleteText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(LevelCompleteText);

    }
}
