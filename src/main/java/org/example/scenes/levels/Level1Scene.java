package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import org.example.GoatQuest;
import org.example.entities.goat.Goat;
import org.example.entities.map.tileMaps.GrassTilemap;
import org.example.entities.map.tileMaps.TilemapLevel1;

public class Level1Scene extends Level {

    private GoatQuest goatQuest;

    public Level1Scene(GoatQuest goatQuest) {
        super(goatQuest);
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupEntities() {
        addEntity(healthText);
        addEntity(hayBaleText);
        Goat goat = new Goat(goatQuest, new Coordinate2D(0,620),healthText, hayBaleText);
        addEntity(goat);
    }

    @Override
    public void setupTileMaps() {
        GrassTilemap GrassTileMap = new TilemapLevel1();
        addTileMap(GrassTileMap);
    }

}
