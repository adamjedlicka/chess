package jeda00.chess.util;

import jeda00.chess.Color;
import jeda00.chess.Coords;
import jeda00.chess.Tile;
import jeda00.chess.figures.Figure;
import jeda00.chess.figures.Pawn;

import java.util.ArrayList;
import java.util.List;

public class GameSetter {

    public List<Tile> defaultGame() {
        List<Tile> tiles = new ArrayList<>();

        for (char row = '8'; row >= '1'; row--) {
            for (char col = 'A'; col <= 'H'; col++) {
                char[] coords = {col, row};

                tiles.add(new Tile(Coords.fromString(new String(coords))));
            }
        }

        addFigureToTiles(new Pawn(Color.WHITE, "A2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "B2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "C2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "D2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "E2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "F2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "G2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "H2"), tiles);

        return tiles;
    }

    private void addFigureToTiles(Figure figure, List<Tile> tiles) {
        tiles.get(figure.getCoords().getIndex()).setFigure(figure);
    }

}
