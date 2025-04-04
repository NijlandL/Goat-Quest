package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.GoatQuest;


public class GameTitle extends SpriteEntity {

    private GoatQuest goatQuest;

    protected GameTitle(Coordinate2D initialLocation, GoatQuest goatQuest) {
        super("GameTitle.png", initialLocation, new Size(200, 200));
        this.goatQuest = goatQuest;
    }
}
