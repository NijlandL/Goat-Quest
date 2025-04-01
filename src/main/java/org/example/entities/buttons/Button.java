package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.GoatQuest;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private GoatQuest goatQuest;

    public Button(GoatQuest goatQuest, Coordinate2D initialLocation, String text){
        super(initialLocation,text);
        this.goatQuest = goatQuest;
    }


    @Override
    public abstract void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D);

    @Override
    public void onMouseEntered(){
        setFill(Color.GRAY);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.WHITE);
        setCursor(Cursor.DEFAULT);
    }

}
