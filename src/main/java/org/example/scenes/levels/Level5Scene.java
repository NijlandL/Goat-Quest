package org.example.scenes.levels;

import org.example.GoatQuest;
import org.example.entities.map.tileMaps.GrassTilemap;
import org.example.entities.map.tileMaps.TilemapLevel4;
import org.example.entities.map.tileMaps.TilemapLevel5;

public class Level5Scene extends Level {

    public Level5Scene(GoatQuest goatQuest) {
        super(goatQuest);
    }

    @Override
    public void setupTileMaps() {
        GrassTilemap GrassTileMap = new TilemapLevel5();
        addTileMap(GrassTileMap);
    }
}
