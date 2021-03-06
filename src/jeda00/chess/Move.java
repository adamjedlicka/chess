package jeda00.chess;

import jeda00.chess.figures.Figure;

public class Move implements Comparable<Move> {

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

    public boolean takesFigure() {
        return board.getTile(to).isOccupied();
    }

    public int getValue() {
        return takesFigure()
                ? board.getTile(to).getFigure().getValue()
                : 0;
    }

    public Figure getFigure() {
        return figure;
    }

    public Coords getFrom() {
        return from;
    }

    public Coords getTo() {
        return to;
    }

    public Color getPlayerColor() {
        return figure.getColor();
    }

    private void checkLegality() throws IllegalMoveException {
        if (from == to) {
            throw new IllegalMoveException("Figure has to move somewhere else.");
        }

        if (board.getTile(to).isOccupiedBy(figure.getColor())) {
            throw new IllegalMoveException("Cannot take your own figure.");
        }
    }


    @Override
    public int compareTo(Move move) {
        return move.getValue() - this.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(figure);
        sb.append(" to: ");
        sb.append(to);

        if (board.getTile(to).isOccupied()) {
            sb.append('\n');
            sb.append("Figure taken: ");
            sb.append(board.getTile(to).getFigure());
        }

        return sb.toString();
    }
}
