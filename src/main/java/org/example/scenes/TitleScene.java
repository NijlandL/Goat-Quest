package org.example.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.GoatQuest;

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

    }
}
