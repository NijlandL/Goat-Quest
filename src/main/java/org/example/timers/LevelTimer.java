package org.example.timers;

import com.github.hanyaeger.api.Timer;
import org.example.GoatQuest;
import org.example.scenes.levels.Level;
import org.example.text.LevelTimerText;

public class LevelTimer extends Timer {

    private static final int TOTAL_TIME = 60; // seconden
    private int secondsLeft = TOTAL_TIME;

    private LevelTimerText timerText;
    private Level level;
    private GoatQuest goatQuest;

    public LevelTimer(Level level, GoatQuest goatQuest, LevelTimerText timerText) {
        super(1000); // elke seconde
        this.level = level;
        this.goatQuest = goatQuest;
        this.timerText = timerText;
        timerText.setTime(secondsLeft);
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        secondsLeft--;
        timerText.setTime(secondsLeft);

        if (secondsLeft <= 0) {
            remove();
            goatQuest.setActiveScene(8); // GameOverScene
        }
    }
}
