package jeda00.chess;

import jeda00.chess.figures.Figure;
import jeda00.chess.figures.King;
import jeda00.chess.util.GameSetter;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Board board;

    private Color activePlayerColor;

    public Game() {
        this.board = new GameSetter().defaultBoard();
        this.activePlayerColor = Color.WHITE;
    }

    public Game(Game game) {
        this.board = new GameSetter().emptyBoard();
        this.activePlayerColor = game.activePlayerColor;

        for (Figure figure : game.getBoard().getFigures()) {
            this.board.getTile(figure.getCoords()).setFigure(figure.copyToNewBoard(this.board));
        }
    }

    public void makeMove(Move move) throws IllegalMoveException {
        if (!move.getTo().inBounds()) {
            throw new IllegalMoveException("Move out of bounds: " + move);
        }

        Tile from = board.getTile(move.getFrom());
        Tile to = board.getTile(move.getTo());

        Figure figure = from.getFigure();

        if (figure.getColor() != activePlayerColor) {
            throw new IllegalMoveException("Cannot move opponent's figure.");
        }

        if (to.isOccupied()) {
            to.removeFigure();
        }

        from.removeFigure();
        to.setFigure(figure);

        activePlayerColor = activePlayerColor.opposite();
    }

    public List<Figure> getActiveFigures() {
        return board.getFigures().stream()
                .filter(figure -> figure.getColor() == activePlayerColor)
                .collect(Collectors.toList());
    }

    public boolean isGameOver() {
        return board.getFigures().stream()
                .filter(figure -> figure instanceof King)
                .count() != 2;
    }

    public Color getWinner() {
        boolean whiteKingAlive = board.getFigures().stream()
                .filter(figure -> figure instanceof King)
                .filter(figure -> figure.isWhite())
                .count() == 1;

        boolean blackKingAlive = board.getFigures().stream()
                .filter(figure -> figure instanceof King)
                .filter(figure -> figure.isBlack())
                .count() == 1;

        if (!whiteKingAlive) {
            return Color.BLACK;
        }

        if (!blackKingAlive) {
            return Color.WHITE;
        }

        return null;
    }

    public Board getBoard() {
        return board;
    }

    public Color getActivePlayerColor() {
        return activePlayerColor;
    }

}
