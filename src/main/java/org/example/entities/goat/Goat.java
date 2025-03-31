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
import org.example.entities.map.GrassBlock;


import java.util.List;
import java.util.Set;

public class Goat extends DynamicSpriteEntity implements KeyListener, Newtonian, Collided {

    private static final int WALKING_SPEED = 3;
    private static final int JUMP_SPEED = 15;

    GoatQuest goatQuest;
    private boolean isOnGround = false;
    private double direction = Direction.RIGHT.getValue();
    private Set<KeyCode> latestPressedKeys;


    public Goat(Coordinate2D initialLocation, GoatQuest goatQuest) {
        super("goatSprite/goatFullSprite.png", initialLocation, new Size(50, 50), 1, 2);
        this.goatQuest = goatQuest;
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
            // Alleen stoppen als op de grond
            setSpeed(0);
        }
    }


    @Override
    public void onCollision(List<Collider> colliders) {
        // Begin elke frame met de aanname dat de goat in de lucht is.
        isOnGround = false;

        // Loop door alle objecten waarmee de goat op dat moment botst.
        for (Collider collider : colliders) {
            // Controleer of het een GrassBlock is
            if (collider instanceof GrassBlock grassBlock) {

                // Bepaal de onderkant (Y) van de goat
                double goatBottom = getBoundingBox().getMaxY();
                // Bepaal de bovenkant (Y) van het grass block
                double blockTop = grassBlock.getBoundingBox().getMinY();

                // Controleer of de goat van boven op het blok komt (dus niet tegen de zijkant of onderkant)
                // De +10 is een kleine marge om ervoor te zorgen dat lichte overlappingen door snelheid niet fout gaan
                if (goatBottom <= blockTop + 10) {
                    // Geef aan dat de goat op de grond staat
                    isOnGround = true;

                    // Stop de verticale beweging (vallen / springen)
                    setMotion(0, 0);

                    // Behoud de huidige snelheid (vooral handig als hij horizontaal beweegt)
                    // setSpeed(getSpeed()) is een beetje dubbel, je zou ook alleen de verticale snelheid op 0 kunnen zetten
                    setSpeed(getSpeed());

                    // Eén grass block is genoeg om op te staan, dus we stoppen de lus
                    break;
                }
            }
        }
    }

}


