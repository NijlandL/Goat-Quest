package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.GoatQuest;
import org.example.entities.buttons.MainMenuButton;

public class GameOverScene extends StaticScene {

    private GoatQuest goatQuest;

    protected GameOverScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.jpg");
    }

    @Override
    public void setupEntities() {
        var mainMenuButton = new MainMenuButton(goatQuest, new Coordinate2D(10, 0));
        addEntity(mainMenuButton);

    }
}
