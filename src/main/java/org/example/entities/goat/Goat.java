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
import org.example.entities.map.hayBale.HayBale;
import org.example.entities.map.grassBlock.GrassHitbox;
import org.example.entities.map.grassBlock.GrassTopHitbox;
import org.example.text.HayBaleText;
import org.example.text.HealthText;

import java.util.List;
import java.util.Set;

public class Goat extends DynamicSpriteEntity implements KeyListener, Newtonian, Collided, SceneBorderTouchingWatcher, Collider {

    private static final int WALKING_SPEED = 3;
    private static final int JUMP_SPEED = 18;

    private final HealthText healthText;
    private final GoatQuest goatQuest;
    private final HayBaleText hayBalesText;

    private boolean isOnGround = false;
    private double direction = Direction.RIGHT.getValue();
    private int health = 3;
    private int hayBales = 0;
    private Set<KeyCode> latestPressedKeys;
    private int damageCooldown = 60;

    public Goat(Coordinate2D initialLocation, GoatQuest goatQuest, HealthText healthText, HayBaleText hayBaleText) {
        super("goatSprite/goatFullSprite.png", initialLocation, new Size(50, 50), 1, 2);
        this.goatQuest = goatQuest;
        this.healthText = healthText;
        this.hayBalesText = hayBaleText;

        healthText.setHealthText(health);
        hayBaleText.setHayBaleText(hayBales);

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
        } else if (isOnGround) {
            setSpeed(0);
        }
    }

    public void takeDamage(int amount) {
        if (damageCooldown == 0) {
            health -= amount;
            if (health <= 0) {
                goatQuest.setActiveScene(7);
            }
            healthText.setHealthText(health);
            damageCooldown = 60;
        }
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        isOnGround = false;
        boolean collideWithHayBale = false;

        for (Collider collider : colliders) {
            if (collider instanceof GrassTopHitbox) {
                isOnGround = true;
                setMotion(0, 180);
            } else if (collider instanceof GrassHitbox) {
                handleBlockCollision(collider);
            } else if (collider instanceof HayBale && !collideWithHayBale) {
                hayBales++;
                collideWithHayBale = true;
                hayBalesText.setHayBaleText(hayBales);
                ((HayBale) collider).remove();
            } else if (collider instanceof Wolf || collider instanceof Arend) {
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

    private void handleBlockCollision(Collider collider) {
        var goatBox = getBoundingBox();
        var blockBox = collider.getBoundingBox();

        boolean fromRight = goatBox.getMaxX() > blockBox.getMinX() &&
                goatBox.getMinX() < blockBox.getMinX() &&
                goatBox.getMaxY() > blockBox.getMinY() &&
                goatBox.getMinY() < blockBox.getMaxY() &&
                direction == Direction.RIGHT.getValue();

        boolean fromLeft = goatBox.getMinX() < blockBox.getMaxX() &&
                goatBox.getMaxX() > blockBox.getMaxX() &&
                goatBox.getMaxY() > blockBox.getMinY() &&
                goatBox.getMinY() < blockBox.getMaxY() &&
                direction == Direction.LEFT.getValue();

        boolean fromBelow = goatBox.getMinY() < blockBox.getMaxY() &&
                goatBox.getMaxY() > blockBox.getMaxY() &&
                goatBox.getMaxX() > blockBox.getMinX() &&
                goatBox.getMinX() < blockBox.getMaxX();

        if (fromRight) {
            setAnchorLocationX(blockBox.getMinX() - getWidth() - 1);
            setSpeed(0);
        } else if (fromLeft) {
            setAnchorLocationX(blockBox.getMaxX() + 1);
            setSpeed(0);
        } else if (fromBelow) {
            setAnchorLocationY(blockBox.getMaxY());
            setMotion(0, Direction.DOWN.getValue());
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
                setAnchorLocation(new Coordinate2D(0, 600));
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                break;
            default:
                break;
        }
    }

    public int getHayBales() {
        return hayBales;
    }

}
