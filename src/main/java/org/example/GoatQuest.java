package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
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

    @Override
    public void setupGame() {
        setGameTitle("Goat Quest");
        setSize(new Size(800, 600));
    }


    @Override
    public void setupScenes(){
        addScene(0, new TitleScene(this));

    }
}
