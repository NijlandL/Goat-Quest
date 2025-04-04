package org.example.entities.map.hayBale;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.CompositeEntity;


import java.util.List;

public class HayBale extends CompositeEntity implements Collided, Collider {

    public HayBale(Coordinate2D initialLocation, Size size) {
        super(initialLocation);
    }

    @Override
    public void onCollision(List<Collider> colliders) {

    }

    @Override
    protected void setupEntities() {
        HayBaleSprite hayBale = new HayBaleSprite(new Coordinate2D(0,0));
        addEntity(hayBale);
    }
}
