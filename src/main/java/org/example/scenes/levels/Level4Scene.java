package org.example.scenes.levels;

import org.example.GoatQuest;
import org.example.entities.map.tileMaps.GrassTilemap;
import org.example.entities.map.tileMaps.TilemapLevel4;

public class Level4Scene extends Level {

    public Level4Scene(GoatQuest goatQuest) {
        super(goatQuest);
    }

    @Override
    public void setupTileMaps() {
        GrassTilemap GrassTileMap = new TilemapLevel4();
        addTileMap(GrassTileMap);
    }
}
