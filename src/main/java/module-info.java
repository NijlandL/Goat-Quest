module Goat.Quest {
    requires hanyaeger;
    requires java.desktop;

    exports org.example;

    opens decoration;
    opens goatSprite;
    opens obstacles;
    opens tiles;
    opens wolfSprite;
    opens music;
    opens arendSprite;
    exports org.example.entities.map.grassBlock;
    exports org.example.entities.map.tileMaps;
    exports org.example.entities.map.hayBale;


}