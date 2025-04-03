package org.example.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.example.GoatQuest;
import org.example.entities.enemies.Wolf;
import org.example.entities.enemies.Arend;
import org.example.entities.goat.Goat;
import org.example.text.HealthText;

public abstract class Level extends DynamicScene implements TileMapContainer {

    private GoatQuest goatQuest;

    public Level(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.png");
    }

    @Override
    public void setupEntities() {


        var healthText = new HealthText(new Coordinate2D(0,0));
        addEntity(healthText);
        var Goat = new Goat(new Coordinate2D(0,getHeight()-100),goatQuest,healthText);
        addEntity(Goat);
        var Wolf = new Wolf(new Coordinate2D(0,getHeight()-140));
        addEntity(Wolf);
        var Arend = new Arend(new Coordinate2D(0,getHeight()-500));
        addEntity(Arend);



    }

    @Override
    public abstract void setupTileMaps();
//    {
//        GrassTilemap GrassTileMap = new TilemapLevel1();
//        addTileMap(GrassTileMap);
//    }
}
