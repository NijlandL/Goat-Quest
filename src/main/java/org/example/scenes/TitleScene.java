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
        setBackgroundImage("backgroundImage.png");
        setBackgroundAudio("music/GoatQuest Song 1.mp3");
        setBackgroundAudioVolume(0.5);
    }

    @Override
    public void setupEntities() {
        var startButton = new StartButton(goatQuest, new Coordinate2D(getWidth()/2 - 80, getHeight()/2), "Start Game");
        addEntity(startButton);

        var quitButton = new QuitButton(goatQuest, new Coordinate2D(getWidth()/2 - 80, getHeight()/2 + 50), "Quit Game");
        addEntity(quitButton);

        var GameTitle = new GameTitle(new Coordinate2D(getWidth()/2-100, getHeight()/2 - 200), goatQuest);
        addEntity(GameTitle);
    }
}
