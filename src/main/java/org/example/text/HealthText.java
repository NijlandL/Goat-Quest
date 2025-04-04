package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HealthText extends StyledText {
    public HealthText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.rgb(238, 223, 202));
    }

    public void setHealthText(int health){
        setText("Health: " + health);
    }
}

