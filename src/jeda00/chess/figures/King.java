package jeda00.chess.figures;

import jeda00.chess.*;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure {

    public King(Board board, Color color, String coords) {
        super(board, color, Coords.fromString(coords));
    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();
        Coords coords;

        try {
            coords = getCoords().moveUpBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveDownBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveLeftBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveRightBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveUpBy(1).moveLeftBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveDownBy(1).moveLeftBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveUpBy(1).moveRightBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveDownBy(1).moveRightBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }
        } catch (IllegalMoveException e) {
            System.err.println("IllegalMoveException while calculating possible moves for a king.");
            System.err.println(e);
        }

        return moves;
    }

    @Override
    public int getValue() {
        return 1000000;
    }

    @Override
    public String toString() {
        return (isWhite() ? "White" : "Black") + " king at " + getCoords();
    }

    @Override
    public Figure copyToNewBoard(Board board) {
        return new King(board, getColor(), getCoords().toString());
    }
}
