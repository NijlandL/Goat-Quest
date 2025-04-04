package org.example.text;

import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelTimerText extends StyledText {

    public LevelTimerText(Coordinate2D location) {
        super(location);
        setFill(Color.WHITE);
    }

    public void setTime(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        setText(String.format("Tijd: %02d:%02d", minutes, seconds));
    }
}
