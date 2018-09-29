package jeda00.chess.figures;

import jeda00.chess.*;

import java.util.List;

abstract public class Figure {

    private final Board board;

    private final Color color;

    private Coords coords;

    public Figure(Board board, Color color, Coords coords) {
        this.board = board;
        this.color = color;
        this.coords = coords;
    }

    abstract public List<Move> getPossibleMoves();

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
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
