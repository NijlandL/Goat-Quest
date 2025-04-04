package org.example.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entities.goat.Goat;

import java.util.List;
import java.util.Random;

public class Arend extends DynamicSpriteEntity implements TimerContainer, SceneBorderTouchingWatcher, Collided, Collider {

    private static final int AUTOCYCLE_SPEED = 100;

    public Arend(final Coordinate2D initialLocation) {
        super("arendSprite/arendSprite.png", initialLocation);
        setAutoCycle(AUTOCYCLE_SPEED, 0);
        setMotion(2, Direction.RIGHT);
    }

    @Override
    public void setupTimers() {
        addTimer(new ArendTimer(this));
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirection(180);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Goat goat) {
                goat.takeDamage(1); // schade doen
            } else {
                changeDirection(180); // botsing = omkeren
            }
        }
    }

    private void changeFlightDirection() {
        setDirection(new Random().nextDouble() * 360);
    }

    private static class ArendTimer extends Timer {
        private Arend arend;

        protected ArendTimer(final Arend arend) {
            super(new Random().nextInt(500) + 300);
            this.arend = arend;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            if (new Random().nextInt(5) < 2) {
                arend.changeFlightDirection();
            }
        }
    }
}
