package jeda00.chess.ui.javafx;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import jeda00.chess.Board;
import jeda00.chess.Coords;

import java.util.ArrayList;
import java.util.List;

public class FXBoard extends Pane {

    private Board board;

    private List<FXTile> tiles;

    public FXBoard(Board board) {
        this.board = board;
        this.tiles = new ArrayList<>();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                FXTile tile = new FXTile(new Coords(row, col));

                this.tiles.add(tile);
                getChildren().add(tile);
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
