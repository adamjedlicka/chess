package jeda00.chess;

import jeda00.chess.figures.Figure;
import jeda00.chess.util.GameSetter;

import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public static final int DIMENSION = 8;

    private List<Tile> tiles;

    public Board() {
        this.tiles = (new GameSetter()).defaultGame();
    }

    public void moveFigure(Figure figure, Coords coords) {
        tiles.get(figure.getCoords().getIndex()).setFigure(null);
        tiles.get(coords.getIndex()).setFigure(figure);
    }

    public List<Figure> getFigures() {
        return getTiles().stream()
                .map(tile -> tile.getFigure())
                .filter(figure -> figure != null)
                .collect(Collectors.toList());
    }

    public List<Tile> getTiles() {
        return tiles;
    }

}

