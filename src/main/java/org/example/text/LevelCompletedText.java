package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class LevelCompletedText extends StyledText {

    public LevelCompletedText(Coordinate2D initialLocation) {
        super(initialLocation, "Level Completed");
        setFill(Color.GREEN);
    }
}
