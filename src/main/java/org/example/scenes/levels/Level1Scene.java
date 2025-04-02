package org.example.scenes.levels;

import org.example.GoatQuest;
import org.example.entities.map.tileMaps.GrassTilemap;
import org.example.entities.map.tileMaps.TilemapLevel1;

public class Level1Scene extends Level {

    public Level1Scene(GoatQuest goatQuest) {
        super(goatQuest);
    }

    @Override
    public void setupTileMaps() {
        GrassTilemap GrassTileMap = new TilemapLevel1();
        addTileMap(GrassTileMap);
    }
}
