package org.example.entities.map.tileMaps;

import com.github.hanyaeger.api.scenes.TileMap;
import org.example.entities.map.grassBlock.GrassBlock;

public abstract class GrassTilemap extends TileMap {

//    public GrassTilemap() {}

    @Override
    public void setupEntities() {
//        addEntity(1, GrassBlock.class, "tiles/grasBlock_HighGras.png");
        addEntity(2, GrassBlock.class);
//        addEntity(3, GrassBlock.class, "tiles/grasRampUp.png");
//        addEntity(4, GrassBlock.class, "tiles/grasRampDown.png");
//        addEntity(5, GrassBlock.class, "tiles/smallGrasBlock_LowGras.png");
//        addEntity(6, GrassBlock.class, "tiles/dirtBlock.png");
    }


    @Override
    public abstract int[][] defineMap();
    }



