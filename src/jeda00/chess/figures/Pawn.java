package jeda00.chess.figures;

import jeda00.chess.Color;
import jeda00.chess.Coords;

public class Pawn extends Figure {

    public Pawn(Color color, String coords) {
        super(color, Coords.fromString(coords));
    }

}
