package org.example.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class GrassBlockSprite extends SpriteEntity {

    public GrassBlockSprite(final Coordinate2D location) {
        super("tiles/grasBlock_LowGras.png", location);
    }
}
