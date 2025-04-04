//package org.example.entities.enemies;
//
//import com.github.hanyaeger.api.Coordinate2D;
//import com.github.hanyaeger.api.entities.Collided;
//import com.github.hanyaeger.api.entities.Collider;
//import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
//import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
//import com.github.hanyaeger.api.scenes.SceneBorder;
//
//import java.util.List;
//
//public abstract class Enemy extends DynamicSpriteEntity implements Collided, Collider, SceneBorderTouchingWatcher {
//
//    public Enemy(String resource, Coordinate2D location) {
//        super(resource, location);
//    }
//
//    @Override
//    public void onCollision(List<Collider> colliders) {
//        for (Collider collider : colliders) {
//            handleCollision(collider);
//        }
//    }
//
//    protected abstract void handleCollision(Collider collider);
//
//    @Override
//    public void notifyBoundaryTouching(SceneBorder border) {
//        reverseDirection();
//    }
//
//    protected void reverseDirection() {
//        setDirection((getDirection() + 180) % 360);
//    }
//}
