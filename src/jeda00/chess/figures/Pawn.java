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
        Coords coords;

        int verticalDirection = isWhite() ? 1 : -1;

        try {
            coords = getCoords().moveUpBy(1 * verticalDirection);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupied()) {
                moves.add(moveTo(coords));
            }

            if (!wasMoved()) {
                coords = getCoords().moveUpBy(2 * verticalDirection);
                if (coords.inBounds() && !getBoard().getTile(coords).isOccupied()) {
                    moves.add(moveTo(coords));
                }
            }

            coords = getCoords().moveUpBy(1 * verticalDirection).moveLeftBy(1);
            if (coords.inBounds() && getBoard().getTile(coords).isOccupiedBy(getColor().opposite())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveUpBy(1 * verticalDirection).moveRightBy(1);
            if (coords.inBounds() && getBoard().getTile(coords).isOccupiedBy(getColor().opposite())) {
                moves.add(moveTo(coords));
            }
        } catch (IllegalMoveException e) {
            System.err.println("IllegalMoveException while calculating possible moves for a pawn.");
            System.err.println(e);
        }

        return moves;
    }

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public String toString() {
        return (isWhite() ? "White" : "Black") + " pawn at " + getCoords();
    }

    @Override
    public Figure copyToNewBoard(Board board) {
        return new Pawn(board, getColor(), getCoords().toString());
    }

}
