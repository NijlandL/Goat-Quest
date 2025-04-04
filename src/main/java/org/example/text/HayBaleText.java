package org.example.text;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class HayBaleText extends StyledText {

    public HayBaleText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.ORANGE);
    }

    public void setHayBaleText(int hayBales){
        setText("Hay Bales: " + hayBales);
    }
}