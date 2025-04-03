package org.example.entities.map.tileMaps;

import com.github.hanyaeger.api.scenes.TileMap;
import org.example.entities.map.grassBlock.GrassBlock;

public abstract class GrassTilemap extends TileMap {

//    public GrassTilemap() {}

    @Override
    public void setupEntities() {
        addEntity(1, GrassBlock.class);
    }


    @Override
    public abstract int[][] defineMap();
    }



