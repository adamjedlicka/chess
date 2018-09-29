package jeda00.chess.ui.javafx;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import jeda00.chess.Board;
import jeda00.chess.Coords;
import jeda00.chess.Tile;

import java.util.ArrayList;
import java.util.List;

public class FXBoard extends Pane {

    private Board board;

    private List<FXTile> tiles;

    private List<FXFigure> figures;

    public FXBoard(Board board) {
        this.board = board;
        this.tiles = new ArrayList<>();
        this.figures = new ArrayList<>();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Coords coords = new Coords(row, col);
                Tile tile = board.getTile(coords);

                FXTile fxTile = new FXTile(board.getTile(coords));

                this.tiles.add(fxTile);
                getChildren().add(fxTile);

                if (tile.getFigure() != null) {
                    FXFigure fxFigure = new FXFigure(tile.getFigure());

                    this.figures.add(fxFigure);
                    getChildren().add(fxFigure);
                }
            }
        }

        setOnMouseClicked(this::onClick);
    }

    private void onClick(MouseEvent mouseEvent) {
        int row = (int) mouseEvent.getY() / FXTile.SIZE;
        int col = (int) mouseEvent.getX() / FXTile.SIZE;

        Coords coords = new Coords(row, col);

        tiles.forEach(tile -> tile.deactivate());
        tiles.get(coords.getIndex()).activate();
    }
}
