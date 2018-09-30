package jeda00.chess.figures;

import jeda00.chess.*;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Figure {

    public Queen(Board board, Color color, String coords) {
        super(board, color, Coords.fromString(coords));
    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Direction> directions = Direction.straightAndDiagonal();
        List<Move> moves = new ArrayList<>();
        Coords coords;

        try {
            for (Direction direction : directions) {
                for (int distance = 1; distance < Board.DIMENSION; distance++) {
                    coords = getCoords().moveInDirectionBy(direction, distance);

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
            }
        } catch (IllegalMoveException e) {
            System.err.println("IllegalMoveException while calculating possible moves for a queen.");
            System.err.println(e);
        }

        return moves;
    }

    @Override
    public int getValue() {
        return 50;
    }

    @Override
    public Figure copyToNewBoard(Board board) {
        return new Queen(board, getColor(), getCoords().toString());
    }
}
