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

    @Override
    public void setupGame() {
        setGameTitle("Goat Quest");
        setSize(new Size(1280, 720));
    }


    @Override
    public void setupScenes(){
        addScene(0, new TitleScene(this));
        addScene(1,new LevelScene(this));
        addScene(2, new Level1Scene(this));
        addScene(3, new Level2Scene(this));
        addScene(4, new Level3Scene(this));
        addScene(5, new Level4Scene(this));
        addScene(6, new Level5Scene(this));
        addScene(7, new GameOverScene(this));
        addScene(8, new LevelCompletedScene(this));

    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
