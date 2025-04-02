package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.GoatQuest;
import org.example.entities.buttons.MainMenuButton;
import org.example.entities.buttons.RetryLevelButton;

public class GameOverScene extends StaticScene {

    private GoatQuest goatQuest;

    public GameOverScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.png");
    }

    @Override
    public void setupEntities() {
        var mainMenuButton = new MainMenuButton(goatQuest, new Coordinate2D(getWidth()/2,getHeight()/2));
        mainMenuButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(mainMenuButton);

        var retryLevelButton = new RetryLevelButton(goatQuest, new Coordinate2D(getWidth()/2,getHeight()/3*2));
        retryLevelButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(retryLevelButton);

    }
}
