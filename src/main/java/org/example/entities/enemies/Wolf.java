package org.example.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entities.map.GrassBlock;


import java.util.List;
import java.util.Random;

public class Wolf extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Newtonian, Collided, Collider {

    public Wolf(Coordinate2D location) {
        super("wolfSprite/wolf.png", location, new Size(50,50),1,2);
        setMotion(2, 270d);
        setFrictionConstant(0.05);
        setGravityConstant(0.5);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) (getSceneHeight() - getHeight())));
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        // Begin elke frame met de aanname dat de goat in de lucht is.


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
