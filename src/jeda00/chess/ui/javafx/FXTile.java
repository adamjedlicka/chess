package jeda00.chess.ui.javafx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jeda00.chess.Coords;
import jeda00.chess.Tile;
import jeda00.chess.figures.Figure;

public class FXTile extends Rectangle {

    public static final int SIZE = 100;

    private final Tile tile;

    private boolean active;

    public FXTile(Tile tile) {
        this.tile = tile;
        this.active = false;

        setX(tile.getCoords().getCol() * SIZE);
        setY(tile.getCoords().getRow() * SIZE);
        setWidth(SIZE);
        setHeight(SIZE);

        deactivate();
    }

    public void activate() {
        setFill(tile.isWhite() ? Color.LIGHTSTEELBLUE : Color.STEELBLUE);
    }

    public void deactivate() {
        setFill(tile.isWhite() ? Color.LIGHTGRAY : Color.DARKGRAY);
    }

    public Tile getTile() {
        return tile;
    }

    public Figure getFigure() {
        return tile.getFigure();
    }

    public Coords getCoords() {
        return tile.getCoords();
    }

}
