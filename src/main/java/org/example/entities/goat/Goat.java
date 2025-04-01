package org.example.entities.goat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.GoatQuest;
import org.example.entities.enemies.Wolf;
import org.example.entities.map.GrassBlock;
import org.example.text.HealthText;


import java.util.List;
import java.util.Set;

public class Goat extends DynamicSpriteEntity implements KeyListener, Newtonian, Collided {

    private static final int WALKING_SPEED = 3;
    private static final int JUMP_SPEED = 15;

    private HealthText healthText;
    GoatQuest goatQuest;
    private boolean isOnGround = false;
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
            if (health < 0) {
                health = 0;
            }
            healthText.setHealthText(health);
            damageCooldown = 60;
        }
    }


    @Override
    public void onCollision(List<Collider> colliders) {
        isOnGround = false;

        for (Collider collider : colliders) {
            if (collider instanceof GrassBlock grassBlock) {
                double goatBottom = getBoundingBox().getMaxY();
                double blockTop = grassBlock.getBoundingBox().getMinY();

                if (goatBottom <= blockTop + 10) {
                    isOnGround = true;
                    setMotion(0, 0);
                    setSpeed(getSpeed());
                    break;
                }
            }

            if (collider instanceof Wolf) {
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
    }
}



