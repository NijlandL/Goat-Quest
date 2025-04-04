package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelCompletedText extends TextEntity {

    public LevelCompletedText(Coordinate2D initialLocation) {
        super(initialLocation, "Level Completed");
        setFont(Font.font("Roboto", FontWeight.NORMAL, 50));
        setFill(Color.GREEN);
    }

}
