module Goat.Quest {
    requires hanyaeger;
    requires java.desktop;

    exports org.example;
    exports org.example.entities.map;

    opens decoration;
    opens goatSprite;
    opens obstacles;
    opens tiles;




}