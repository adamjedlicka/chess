package jeda00.chess;

import jeda00.chess.figures.Figure;

public class Move {

    private final Board board;

    private final Figure figure;

    private final Coords from;

    private final Coords to;

    public Move(Board board, Figure figure, Coords to) throws IllegalMoveException {
        this.board = board;
        this.figure = figure;
        this.from = figure.getCoords();
        this.to = to;

        checkLegality();
    }

    public Coords getTo() {
        return to;
    }

    private void checkLegality() throws IllegalMoveException {
        if (from == to) {
            throw new IllegalMoveException("Figure has to move somewhere else.");
        }

        if (board.getTile(to).isOccupiedBy(figure.getColor())) {
            throw new IllegalMoveException("Cannot take your own figure.");
        }
    }

}
