package org.example.entities.goat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.GoatQuest;
import org.example.entities.map.GrassBlock;


import java.util.List;
import java.util.Set;

public class Goat extends DynamicSpriteEntity implements KeyListener, Newtonian, Collided {

    GoatQuest goatQuest;
    private boolean isOnGround;


    public Goat(Coordinate2D initialLocation, GoatQuest goatQuest) {
        super("goatSprite/Goat_normal.png", initialLocation, new Size(50, 50));
        this.goatQuest = goatQuest;
        setFrictionConstant(0.05);
        setGravityConstant(0.5);
        isOnGround = false;

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (isOnGround) {
            if (pressedKeys.contains(KeyCode.A)) {
                setMotion(3, 270d);
                setCurrentFrameIndex(0);
            } else if (pressedKeys.contains(KeyCode.D)) {
                setMotion(3, 90d);
                setCurrentFrameIndex(1);
            } else {
                setMotion(0, 0);
            }
        }
        // Het Geitje kan alleen springen als hij op de grond is (zo vliegt hij niet)
        if (pressedKeys.contains(KeyCode.SPACE) && isOnGround) {
            setMotion(10, 180d);
            isOnGround = false;
        }

    }

    @Override
    public void onCollision(List<Collider> list) {
        var grassCollision = false;
        isOnGround = false;
        for (Collider collider : list) {
            if (collider instanceof GrassBlock) {
                grassCollision = true;
                isOnGround = true;
                setMotion(0, 0);
                break;
            }
        }
    }
}

