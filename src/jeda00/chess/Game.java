package jeda00.chess;

import jeda00.chess.figures.Figure;
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

    public void makeMove(Move move) {
        Tile from = board.getTile(move.getFrom());
        Tile to = board.getTile(move.getTo());

        if (to.isOccupied()) {
            System.out.println("Figure taken: " + to.getFigure());
            to.removeFigure();
        }

        from.removeFigure();
        to.setFigure(move.getFigure());

        activePlayerColor = activePlayerColor.opposite();
    }

    public List<Figure> getActiveFigures() {
        return board.getFigures().stream()
                .filter(figure -> figure.getColor() == activePlayerColor)
                .collect(Collectors.toList());
    }

    public Board getBoard() {
        return board;
    }

}
