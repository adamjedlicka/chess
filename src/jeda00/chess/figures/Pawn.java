package jeda00.chess.figures;

import jeda00.chess.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure {

    public Pawn(Board board, Color color, String coords) {
        super(board, color, Coords.fromString(coords));
    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();

        int verticalDirection = isWhite() ? 1 : -1;

        try {
            Coords step = getCoords().moveUpBy(1 * verticalDirection);
            if (!getBoard().getTile(step).isOccupied()) {
                moves.add(moveTo(step));
            }

            Coords takeLeft = getCoords().moveUpBy(1 * verticalDirection).moveLeftBy(1);
            if (getBoard().getTile(takeLeft).isOccupiedBy(getColor().opposite())) {
                moves.add(moveTo(takeLeft));
            }

            Coords takeRight = getCoords().moveUpBy(1 * verticalDirection).moveRightBy(1);
            if (getBoard().getTile(takeRight).isOccupiedBy(getColor().opposite())) {
                moves.add(moveTo(takeRight));
            }
        } catch (IllegalMoveException e) {
            System.err.println("IllegalMoveException while calculating possible moves for a pawn.");
            System.err.println(e);
        }

        return moves;
    }

}
