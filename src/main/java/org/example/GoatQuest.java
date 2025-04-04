package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.GameOverScene;
import org.example.scenes.LevelCompletedScene;
import org.example.scenes.levels.*;
import org.example.scenes.LevelScene;
import org.example.scenes.TitleScene;

/**
 * Hello world!
 *
 */
public class GoatQuest extends YaegerGame
{
    public static void main(String[] args){
        launch(args);
    }

    private int currentLevel = 1;
    private final int TITLESCENE = 0;
    private final int LEVELSCENE = 6;
    private final int LEVEL1SCENE = 1;
    private final int LEVEL2SCENE = 2;
    private final int LEVEL3SCENE = 3;
    private final int LEVEL4SCENE = 4;
    private final int LEVEL5SCENE = 5;
    private final int GAMEOVERSCENE = 7;
    private final int LEVELCOMPLETEDSCENE = 8;
            ;








    @Override
    public void setupGame() {
        setGameTitle("Goat Quest");
        setSize(new Size(1280, 720));
    }


    @Override
    public void setupScenes(){
        addScene(0, new TitleScene(this));
        addScene(6,new LevelScene(this));
        addScene(1, new Level1Scene(this));
        addScene(2, new Level2Scene(this));
        addScene(3, new Level3Scene(this));
        addScene(4, new Level4Scene(this));
        addScene(5, new Level5Scene(this));
        addScene(7, new GameOverScene(this));
        addScene(8, new LevelCompletedScene(this));

    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getTITLESCENE() {
        return TITLESCENE;
    }

    public int getLEVELSCENE() {
        return LEVELSCENE;
    }

    public int getLEVEL1SCENE() {
        return LEVEL1SCENE;
    }

    public int getLEVEL2SCENE() {
        return LEVEL2SCENE;
    }

    public int getLEVEL3SCENE() {
        return LEVEL3SCENE;
    }

    public int getLEVEL4SCENE() {
        return LEVEL4SCENE;
    }

    public int getLEVEL5SCENE() {
        return LEVEL5SCENE;
    }

    public int getGAMEOVERSCENE() {
        return GAMEOVERSCENE;
    }

    public int getLEVELCOMPLETEDSCENE() {
        return LEVELCOMPLETEDSCENE;
    }
}
