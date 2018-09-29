package jeda00.chess.ui.javafx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jeda00.chess.Coords;

public class FXTile extends Rectangle {

    public static final int SIZE = 100;

    private Coords coords;

    private boolean active;

    public FXTile(Coords coords) {
        this.coords = coords;
        this.active = false;

        setX(coords.getCol() * SIZE);
        setY(coords.getRow() * SIZE);
        setWidth(SIZE);
        setHeight(SIZE);

        deactivate();
    }

    public void activate() {
        setFill(coords.isWhite() ? Color.LIGHTSTEELBLUE : Color.STEELBLUE);
    }

    public void deactivate() {
        setFill(coords.isWhite() ? Color.LIGHTGRAY : Color.DARKGRAY);
    }

}
