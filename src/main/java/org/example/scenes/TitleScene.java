package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import org.example.GoatQuest;
import org.example.entities.buttons.QuitButton;
import org.example.entities.buttons.StartButton;

public class TitleScene extends StaticScene {

    private GoatQuest goatQuest;

    public TitleScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.jpg");
    }

    @Override
    public void setupEntities() {
        var startButton = new StartButton(goatQuest, new Coordinate2D(getWidth()/2 - 55, getHeight()/2), "Start Game", Color.WHITE);
        addEntity(startButton);

        var quitButton = new QuitButton(goatQuest, new Coordinate2D(getWidth()/2 - 55, getHeight()/2 + 50), "Quit Game", Color.WHITE);
        addEntity(quitButton);
    }
}
