package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.example.GoatQuest;
import org.example.entities.goat.Goat;
import org.example.entities.map.GrassTilemap;

public class GameScene extends DynamicScene implements TileMapContainer {

    private GoatQuest goatQuest;

    public GameScene(GoatQuest goatQuest) {
        this.goatQuest = goatQuest;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgroundImage.jpg");
    }

    @Override
    public void setupEntities() {
        var Goat = new Goat(new Coordinate2D(50, 480), goatQuest);
        addEntity(Goat);

    }

    @Override
    public void setupTileMaps() {
        var GrassTileMap = new GrassTilemap();
        addTileMap(GrassTileMap);
    }
}
