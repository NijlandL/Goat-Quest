package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.example.GoatQuest;
import org.example.text.HealthText;
import org.example.text.HayBaleText;
import org.example.text.LevelTimerText;
import org.example.timers.LevelTimer;

public abstract class Level extends DynamicScene implements TileMapContainer, TimerContainer {

    private GoatQuest goatQuest;
    private LevelTimerText levelTimerText;
    private LevelTimer countdownTimer;
    protected HealthText healthText = new HealthText(new Coordinate2D(0,0));
    protected HayBaleText hayBaleText = new HayBaleText(new Coordinate2D(0,30));

    public Level(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.png");
        setBackgroundAudio("music/GoatQuest Song 1.mp3");
    }

    @Override
    public abstract void setupEntities();

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



