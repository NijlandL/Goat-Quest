package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.example.GoatQuest;
import org.example.entities.enemies.Wolf;
import org.example.entities.goat.Goat;
import org.example.entities.map.tileMaps.GrassTilemap;
import org.example.entities.map.tileMaps.TilemapLevel1;
import org.example.entities.map.tileMaps.TilemapLevel2;
import org.example.text.HealthText;

public class Level2Scene extends Level {

    public Level2Scene(GoatQuest goatQuest) {
        super(goatQuest);
    }

    @Override
    public void setupTileMaps() {
        GrassTilemap GrassTileMap = new TilemapLevel2();
        addTileMap(GrassTileMap);
    }
}

