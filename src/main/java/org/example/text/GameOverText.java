package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class GameOverText extends StyledText {

    public GameOverText(Coordinate2D initialLocation) {
        super(initialLocation, "Game Over");
        setFill(Color.RED);
    }
}