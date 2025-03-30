package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.GoatQuest;

public class QuitButton extends Button {

    GoatQuest goatQuest;

    public QuitButton(GoatQuest goatQuest, Coordinate2D initialLocation, String text, Color color) {
        super(goatQuest, initialLocation, text);
        this.goatQuest = goatQuest;
        setFill(color);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        goatQuest.quit();
    }
}
