package jeda00.chess;

import jeda00.chess.figures.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public static final int DIMENSION = 8;

    private final List<Tile> tiles;

    public Board() {
        this.tiles = new ArrayList<>();
    }

    public List<Figure> getFigures() {
        return getTiles().stream()
                .map(tile -> tile.getFigure())
                .filter(figure -> figure != null)
                .collect(Collectors.toList());
    }

    public Tile getTile(Coords coords) {
        return tiles.get(coords.getIndex());
    }

    public List<Tile> getTiles() {
        return tiles;
    }

}

