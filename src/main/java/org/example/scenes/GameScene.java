package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.example.GoatQuest;
import org.example.entities.enemies.Wolf;
import org.example.entities.goat.Goat;
import org.example.entities.map.GrassTilemap;
import org.example.text.HealthText;

import java.awt.*;

public class GameScene extends DynamicScene implements TileMapContainer {

    private GoatQuest goatQuest;

    public GameScene(GoatQuest goatQuest) {
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
        var Wolf = new Wolf(new Coordinate2D(300,0));
        addEntity(Wolf);

    }

    @Override
    public void setupTileMaps() {
        var GrassTileMap = new GrassTilemap();
        addTileMap(GrassTileMap);
    }
}
