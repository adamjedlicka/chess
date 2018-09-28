package jeda00.chess;

import jeda00.chess.figures.Figure;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Board board;

    private Color activePlayerColor;

    public Game() {
        this.board = new Board();
        this.activePlayerColor = Color.WHITE;
    }

    public void moveFigure(Figure figure, Coords coords) {
        board.moveFigure(figure, coords);

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
