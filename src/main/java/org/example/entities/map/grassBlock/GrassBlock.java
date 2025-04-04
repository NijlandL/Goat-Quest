package org.example.entities.map.grassBlock;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.CompositeEntity;

public class GrassBlock extends CompositeEntity implements Collider {

    public GrassBlock(Coordinate2D location, Size size) {
        super(location);
    }

    @Override
    protected void setupEntities() {
        GrassBlockSprite grasBlock = new GrassBlockSprite(new Coordinate2D(0, 0));
        GrassHitbox hitbox = new GrassHitbox(new Coordinate2D(0, 22), 64, 50);
        GrassTopHitbox hitboxTop = new GrassTopHitbox(new Coordinate2D(0, 12), 64, 16);
        addEntity(grasBlock);
        addEntity(hitbox);
        addEntity(hitboxTop);

    }
}
