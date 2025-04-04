package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class HealthText extends StyledText {
    public HealthText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.rgb(238, 223, 202));
    }

    public void setHealthText(int health){
        setText("Health: " + health);
    }
}

