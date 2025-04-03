package org.example.entities.goat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.GoatQuest;
import org.example.entities.enemies.Arend;
import org.example.entities.enemies.Wolf;
import org.example.entities.map.grassBlock.GrassHitbox;
import org.example.entities.map.grassBlock.GrassTopHitbox;
import org.example.text.HealthText;


import java.util.List;
import java.util.Set;

public class Goat extends DynamicSpriteEntity implements KeyListener, Newtonian, Collided, SceneBorderTouchingWatcher {

    private static final int WALKING_SPEED = 3;
    private static final int JUMP_SPEED = 18;

    private HealthText healthText;
    GoatQuest goatQuest;
    private boolean isOnGround = false;
    private boolean blockCollision = false;
    private double direction = Direction.RIGHT.getValue();
    private int health = 3;
    private Set<KeyCode> latestPressedKeys;
    private int damageCooldown = 60;


    public Goat(Coordinate2D initialLocation, GoatQuest goatQuest, HealthText healthText) {
        super("goatSprite/goatFullSprite.png", initialLocation, new Size(50, 50), 1, 2);
        this.goatQuest = goatQuest;
        this.healthText = healthText;
        healthText.setHealthText(health);

        setFrictionConstant(0.05);
        setGravityConstant(0.5);


    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        this.latestPressedKeys = pressedKeys;

        if (pressedKeys.contains(KeyCode.SPACE) && isOnGround) {
            addToMotion(JUMP_SPEED, Direction.UP);
            isOnGround = false;
        }

        if (pressedKeys.contains(KeyCode.D)) {
            direction = Direction.RIGHT.getValue();
            maximizeMotionInDirection(direction, WALKING_SPEED);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.A)) {
            direction = Direction.LEFT.getValue();
            maximizeMotionInDirection(direction, WALKING_SPEED);
            setCurrentFrameIndex(0);
        } else if (isOnGround && !(pressedKeys.contains(KeyCode.D) || pressedKeys.contains(KeyCode.A))) {
            setSpeed(0);
        }
    }

    public void takeDamage(int amount) {
        if (damageCooldown == 0) {
            health -= amount;
            if (health <= 0) {
                goatQuest.setActiveScene(7);
//                health = 0;
            }
            healthText.setHealthText(health);
            damageCooldown = 60;
        }
    }


    @Override
    public void onCollision(List<Collider> colliders) {
        isOnGround = false;
        blockCollision = false;


        for (Collider collider : colliders) {
            if (collider instanceof GrassTopHitbox) {
                isOnGround = true;
                setSpeed(getSpeed());
                setMotion(0.01, 180);
            } else if (collider instanceof GrassHitbox) {
                System.out.println("GrasBlock geraakt");
                blockCollision = true;
            }

            if (collider instanceof Wolf || collider instanceof Arend) {
                takeDamage(1);
            }
        }

        if (isOnGround && latestPressedKeys != null &&
                (latestPressedKeys.contains(KeyCode.D) || latestPressedKeys.contains(KeyCode.A))) {
            onPressedKeysChange(latestPressedKeys);
        }

        if (damageCooldown > 0) {
            damageCooldown--;
        }

        if (blockCollision) {
            if(latestPressedKeys.contains(KeyCode.A)) {
                setMotion(0, Direction.LEFT);
                setSpeed(getSpeed());
            } else if (latestPressedKeys.contains(KeyCode.D)) {
                setMotion(0, Direction.RIGHT);
                setSpeed(getSpeed());
            } else if (latestPressedKeys.contains(KeyCode.SPACE)) {
                setMotion(0, Direction.DOWN);
                setSpeed(0);
            }
//            setMotion(0, getDirection());
            if (latestPressedKeys.contains(KeyCode.SPACE) && latestPressedKeys.contains(KeyCode.A)) {
                setMotion(2, Direction.DOWN);
            }
//            else if (latestPressedKeys.contains(KeyCode.SPACE) && latestPressedKeys.contains(KeyCode.D)) {
//                setMotion(2, Direction.DOWN);
//            }
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                takeDamage(1);
                setAnchorLocation(new Coordinate2D(0,600));
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }
}



