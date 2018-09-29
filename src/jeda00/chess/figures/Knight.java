package jeda00.chess.figures;

import jeda00.chess.*;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Figure {

    public Knight(Board board, Color color, String coords) {
        super(board, color, Coords.fromString(coords));
    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();
        Coords coords;

        try {
            coords = getCoords().moveUpBy(2).moveLeftBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveDownBy(2).moveLeftBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveUpBy(2).moveRightBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveDownBy(2).moveRightBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveLeftBy(2).moveUpBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveRightBy(2).moveUpBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveLeftBy(2).moveDownBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }

            coords = getCoords().moveRightBy(2).moveDownBy(1);
            if (coords.inBounds() && !getBoard().getTile(coords).isOccupiedBy(getColor())) {
                moves.add(moveTo(coords));
            }
        } catch (IllegalMoveException e) {
            System.err.println("IllegalMoveException while calculating possible moves for a knight.");
            System.err.println(e);
        }


        return moves;
    }

    @Override
    public int getValue() {
        return 5;
    }

    @Override
    public String toString() {
        return (isWhite() ? "White" : "Black") + " knight at " + getCoords();
    }

    @Override
    public Figure copyToNewBoard(Board board) {
        return new Knight(board, getColor(), getCoords().toString());
    }

}
