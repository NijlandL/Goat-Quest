package org.example.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class GrassHitbox extends RectangleEntity implements Collider {

    private int height;
    private int width;

    public GrassHitbox(final Coordinate2D initialPosition, final int width, final int height) {
        super(initialPosition);
        this.height = height;
        this.width = width;
        setWidth(width);
        setHeight(height);
        setFill(Color.RED);
    }
}
