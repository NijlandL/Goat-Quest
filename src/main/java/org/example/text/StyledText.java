package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public abstract class StyledText extends TextEntity {

    public StyledText(Coordinate2D location) {
        super(location);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    public StyledText(Coordinate2D location, String text) {
        super(location, text);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }
}
