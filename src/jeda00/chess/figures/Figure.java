package jeda00.chess.figures;

import jeda00.chess.Color;
import jeda00.chess.Coords;

abstract public class Figure {

    private final Color color;

    private Coords coords;

    public Figure(Color color, Coords coords) {
        this.color = color;
        this.coords = coords;
    }

    public Color getColor() {
        return color;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

}
