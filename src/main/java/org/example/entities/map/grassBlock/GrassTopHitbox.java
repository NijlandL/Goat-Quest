package org.example.entities.map.grassBlock;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class GrassTopHitbox extends RectangleEntity implements Collider {

    private int height;
    private int width;

    public GrassTopHitbox(final Coordinate2D initialPosition, final int width, final int height) {
        super(initialPosition);
        this.height = height;
        this.width = width;
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
    }
}
