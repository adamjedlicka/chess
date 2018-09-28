package jeda00.chess.figures;

import jeda00.chess.Color;
import jeda00.chess.Coords;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure {

    public Pawn(Color color, String coords) {
        super(color, Coords.fromString(coords));
    }

    @Override
    public List<Coords> getPossibleMoves() {
        List<Coords> moves = new ArrayList<>();

        if (getColor() == Color.WHITE) {
            moves.add(getCoords().moveUpBy(1));
        } else {
            moves.add(getCoords().moveDownBy(1));
        }

        return moves;
    }

}
