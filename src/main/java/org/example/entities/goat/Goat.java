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

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Goat extends DynamicSpriteEntity implements KeyListener, Newtonian, Collided {

    GoatQuest goatQuest;

    public Goat(Coordinate2D initialLocation, GoatQuest goatQuest) {
        super("goatSprite/Goat_normal.png", initialLocation, new Size(50, 50));
        this.goatQuest = goatQuest;
        setFrictionConstant(0.05);
        setGravityConstant(0.5);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, 180d);
        }

    }

    @Override
    public void onCollision(List<Collider> list) {
        var grassCollision = false;

        for (Collider collider : list) {
            if (collider instanceof GrassBlock) {
                grassCollision = true;
            }
        }
        if (grassCollision) {
            setMotion(0, 180d);
        }
    }
}

