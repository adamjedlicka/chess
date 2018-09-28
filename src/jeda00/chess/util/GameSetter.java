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

        setWhite(tiles);
        setBlack(tiles);

        return tiles;
    }

    private void addFigureToTiles(Figure figure, List<Tile> tiles) {
        tiles.get(figure.getCoords().getIndex()).setFigure(figure);
    }

    private void setWhite(List<Tile> tiles) {
        addFigureToTiles(new Pawn(Color.WHITE, "A2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "B2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "C2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "D2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "E2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "F2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "G2"), tiles);
        addFigureToTiles(new Pawn(Color.WHITE, "H2"), tiles);
    }

    private void setBlack(List<Tile> tiles) {
        addFigureToTiles(new Pawn(Color.BLACK, "A7"), tiles);
        addFigureToTiles(new Pawn(Color.BLACK, "B7"), tiles);
        addFigureToTiles(new Pawn(Color.BLACK, "C7"), tiles);
        addFigureToTiles(new Pawn(Color.BLACK, "D7"), tiles);
        addFigureToTiles(new Pawn(Color.BLACK, "E7"), tiles);
        addFigureToTiles(new Pawn(Color.BLACK, "F7"), tiles);
        addFigureToTiles(new Pawn(Color.BLACK, "G7"), tiles);
        addFigureToTiles(new Pawn(Color.BLACK, "H7"), tiles);
    }

}
