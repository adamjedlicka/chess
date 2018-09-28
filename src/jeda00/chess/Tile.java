package jeda00.chess;

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

    public void setFigure(Figure figure) {
        if (figure != null) {
            figure.setCoords(coords);
        }

        this.figure = figure;
    }

}
