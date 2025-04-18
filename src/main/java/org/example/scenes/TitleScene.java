package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.GoatQuest;
import org.example.entities.buttons.Button;
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
        var GameTitle = new GameTitle(new Coordinate2D(getWidth()/2, getHeight()/3), goatQuest);
        GameTitle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(GameTitle);

        Button startButton = new StartButton(goatQuest, new Coordinate2D(getWidth()/2, getHeight()/3*2));
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);

        Button quitButton = new QuitButton(goatQuest, new Coordinate2D(getWidth()/2, getHeight()/4*3));
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitButton);
    }
}
