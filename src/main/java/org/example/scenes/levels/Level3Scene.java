package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.example.GoatQuest;
import org.example.entities.enemies.Arend;
import org.example.entities.enemies.Wolf;
import org.example.entities.goat.Goat;
import org.example.entities.map.tileMaps.GrassTilemap;
import org.example.entities.map.tileMaps.TilemapLevel1;
import org.example.entities.map.tileMaps.TilemapLevel2;
import org.example.entities.map.tileMaps.TilemapLevel3;
import org.example.text.HayBaleText;
import org.example.text.HealthText;

public class Level3Scene extends Level {

    private GoatQuest goatQuest;

    public Level3Scene(GoatQuest goatQuest) {
        super(goatQuest);
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupEntities() {
        addEntity(healthText);
        addEntity(hayBaleText);
        Goat goat = new Goat(goatQuest, new Coordinate2D(0,620),healthText, hayBaleText);
        addEntity(goat);
        var WolfOnder = new Wolf(new Coordinate2D(250,getHeight()-140));
        addEntity(WolfOnder);
        var WolfBoven = new Wolf(new Coordinate2D(250,getHeight()-320));
        addEntity(WolfBoven);
        var Arend = new Arend(new Coordinate2D(0,getHeight()-500));
        addEntity(Arend);
    }
    @Override
    public void setupTileMaps() {
        GrassTilemap GrassTileMap = new TilemapLevel3();
        addTileMap(GrassTileMap);
    }
}
