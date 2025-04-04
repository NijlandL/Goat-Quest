package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.example.GoatQuest;
import org.example.entities.enemies.Wolf;
import org.example.entities.enemies.Arend;
import org.example.entities.goat.Goat;
import org.example.text.HealthText;
import org.example.text.HayBaleText;
import org.example.text.LevelTimerText;
import org.example.timers.LevelTimer;

public abstract class Level extends DynamicScene implements TileMapContainer, TimerContainer {

    private GoatQuest goatQuest;
    private LevelTimerText levelTimerText;
    private LevelTimer countdownTimer;


    public Level(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.png");
        setBackgroundAudio("music/GoatQuest Song 1.mp3");
    }

    @Override
    public void setupEntities() {



        var healthText = new HealthText(new Coordinate2D(0,0));
        addEntity(healthText);
        var hayBaleText = new HayBaleText(new Coordinate2D(0,200));
        addEntity(hayBaleText);
        var Goat = new Goat(new Coordinate2D(0,getHeight()-100),goatQuest,healthText,hayBaleText);
        addEntity(Goat);
        var Wolf = new Wolf(new Coordinate2D(0,getHeight()-140));
        addEntity(Wolf);
        var Arend = new Arend(new Coordinate2D(0,getHeight()-500));
        addEntity(Arend);



    }

    @Override
    public abstract void setupTileMaps();

    @Override
    public void setupTimers() {
        levelTimerText = new LevelTimerText(new Coordinate2D(getWidth() - 160, 20));
        addEntity(levelTimerText);
        countdownTimer = new LevelTimer(this, goatQuest, levelTimerText);
        addTimer(countdownTimer);
    }


}



