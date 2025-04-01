package org.example.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.List;

public class GrassBlock extends SpriteEntity implements Collided, Collider {

    public GrassBlock(Coordinate2D location, Size size, String name) {
        super(name, location, size);




    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
