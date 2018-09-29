package jeda00.chess;

import com.sun.istack.internal.NotNull;
import jeda00.chess.figures.Figure;

public class Tile {

    private final Coords coords;

    private Figure figure;

    public Tile(Coords coords) {
        this.coords = coords;
    }

    public Coords getCoords() {
        return coords;
    }

    public Color getColor() {
        return coords.getColor();
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(@NotNull Figure figure) {
        figure.setCoords(coords);

        this.figure = figure;
    }

    public void removeFigure() {
        this.figure = null;
    }

    public boolean isOccupied() {
        return figure != null;
    }

    public boolean isOccupiedBy(Color color) {
        return isOccupied() && figure.getColor() == color;
    }

}
