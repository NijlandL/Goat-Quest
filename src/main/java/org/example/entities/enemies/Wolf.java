package org.example.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entities.map.grassBlock.GrassBlock;
import org.example.entities.map.grassBlock.GrassHitbox;

import java.util.List;

public class Wolf extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Newtonian, Collided, Collider {

    private boolean movingRight = true;
    private final int WALKINGSPEED = 2;

    public Wolf(Coordinate2D location) {
        super("wolfSprite/wolf.png", location, new Size(64, 64), 1, 2);
        setGravityConstant(0.5);
        setFrictionConstant(0.05);
        setMotion(WALKINGSPEED, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.LEFT || border == SceneBorder.RIGHT) {
            movingRight = !movingRight;
            double direction = movingRight ? Direction.RIGHT.getValue() : Direction.LEFT.getValue();
            setMotion(2, direction);
            setCurrentFrameIndex(movingRight ? 1 : 0);
        }
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof GrassHitbox) {
                movingRight = !movingRight;
                double direction = movingRight ? Direction.RIGHT.getValue() : Direction.LEFT.getValue();
                setMotion(WALKINGSPEED, direction);

                setCurrentFrameIndex(movingRight ? 1 : 0);
            }
        }
    }
}