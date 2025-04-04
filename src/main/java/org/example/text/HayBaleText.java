package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HayBaleText extends StyledText {

    public HayBaleText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.ORANGE);
    }

    public void setHayBaleText(int hayBales){
        setText("Hay Bales: " + hayBales);
    }
}