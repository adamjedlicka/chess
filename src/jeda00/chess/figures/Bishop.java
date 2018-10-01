package jeda00.chess.figures;

import jeda00.chess.*;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure {

    public Bishop(Board board, Color color, String coords) {
        super(board, color, Coords.fromString(coords));
    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();
        Coords coords;

        try {
            for (int i = 1; i < Board.DIMENSION; i++) {
                coords = getCoords().moveUpBy(i).moveLeftBy(i);

                if (!coords.inBounds()) break;

                if (getBoard().getTile(coords).isOccupiedBy(getColor())) {
                    break;
                } else if (getBoard().getTile(coords).isOccupiedBy(getColor().opposite())) {
                    moves.add(moveTo(coords));
                    break;
                } else {
                    moves.add(moveTo(coords));
                }
            }

            for (int i = 1; i < Board.DIMENSION; i++) {
                coords = getCoords().moveDownBy(i).moveLeftBy(i);

                if (!coords.inBounds()) break;

                if (getBoard().getTile(coords).isOccupiedBy(getColor())) {
                    break;
                } else if (getBoard().getTile(coords).isOccupiedBy(getColor().opposite())) {
                    moves.add(moveTo(coords));
                    break;
                } else {
                    moves.add(moveTo(coords));
                }
            }

            for (int i = 1; i < Board.DIMENSION; i++) {
                coords = getCoords().moveUpBy(i).moveRightBy(i);

                if (!coords.inBounds()) break;

                if (getBoard().getTile(coords).isOccupiedBy(getColor())) {
                    break;
                } else if (getBoard().getTile(coords).isOccupiedBy(getColor().opposite())) {
                    moves.add(moveTo(coords));
                    break;
                } else {
                    moves.add(moveTo(coords));
                }
            }

            for (int i = 1; i < Board.DIMENSION; i++) {
                coords = getCoords().moveDownBy(i).moveRightBy(i);

                if (!coords.inBounds()) break;

                if (getBoard().getTile(coords).isOccupiedBy(getColor())) {
                    break;
                } else if (getBoard().getTile(coords).isOccupiedBy(getColor().opposite())) {
                    moves.add(moveTo(coords));
                    break;
                } else {
                    moves.add(moveTo(coords));
                }
            }
        } catch (IllegalMoveException e) {
            System.err.println("IllegalMoveException while calculating possible moves for a rook.");
            System.err.println(e);
        }


        return moves;
    }

    @Override
    public int getValue() {
        return 10;
    }

    @Override
    public String toString() {
        return (isWhite() ? "White" : "Black") + " bishop at " + getCoords();
    }

    @Override
    public Figure copyToNewBoard(Board board) {
        return new Bishop(board, getColor(), getCoords().toString());
    }

}
