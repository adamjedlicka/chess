package jeda00.chess.figures;

import jeda00.chess.*;

import java.util.Collections;
import java.util.List;

abstract public class Figure {

    private final Board board;

    private final Color color;

    private Coords coords;

    private int moved;

    public Figure(Board board, Color color, Coords coords) {
        this.board = board;
        this.color = color;
        this.coords = coords;

        this.moved = 0;
    }

    abstract public List<Move> getPossibleMoves();

    abstract public int getValue();

    abstract public Figure copyToNewBoard(Board board);

    public Move getBestMove() {
        List<Move> moves = getPossibleMoves();

        Collections.shuffle(moves);
        Collections.sort(moves);

        return !moves.isEmpty() ? moves.get(0) : null;
    }

    public boolean canMoveTo(Coords coords) {
        for (Move move : getPossibleMoves()) {
            if (move.getTo().equals(coords)) {
                return true;
            }
        }

        return false;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public void moved() {
        moved++;
    }

    public boolean wasMoved() {
        return moved > 0;
    }

    public Move moveTo(Coords coords) throws IllegalMoveException {
        return new Move(getBoard(), this, coords);
    }

    public Board getBoard() {
        return board;
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
