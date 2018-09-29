package jeda00.chess.ui.javafx;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import jeda00.chess.*;
import jeda00.chess.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class FXBoard extends Pane {

    private Game game;

    private Board board;

    private List<FXTile> tiles;

    private List<FXFigure> figures;

    private Figure activeFigure;

    public FXBoard(Game game) {
        this.game = game;
        this.board = game.getBoard();
        this.tiles = new ArrayList<>();
        this.figures = new ArrayList<>();

        setOnMouseClicked(this::onClick);

        update();
    }

    private void onClick(MouseEvent mouseEvent) {
        int row = (int) mouseEvent.getY() / FXTile.SIZE;
        int col = (int) mouseEvent.getX() / FXTile.SIZE;

        Coords coords = new Coords(row, col);

        tiles.forEach(tile -> tile.deactivate());

        if (activeFigure != null && activeFigure.canMoveTo(coords)) {
            try {
                game.makeMove(activeFigure.moveTo(coords));
                update();
            } catch (IllegalMoveException e) {
                System.err.println(e);
            }
            activeFigure = null;
        } else {
            Figure figure = board.getTile(coords).getFigure();
            if (figure != null && figure.getColor() == game.getActivePlayerColor()) {
                tiles.get(coords.getIndex()).activate();
                activeFigure = figure;

                activeFigure.getPossibleMoves().forEach(move -> {
                    tiles.get(move.getTo().getIndex()).activate();
                });
            } else {
                activeFigure = null;
            }
        }
    }

    private void update() {
        tiles.clear();
        figures.clear();
        getChildren().clear();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Coords coords = new Coords(row, col);
                Tile tile = board.getTile(coords);

                FXTile fxTile = new FXTile(board.getTile(coords));

                tiles.add(fxTile);
                getChildren().add(fxTile);

                if (tile.getFigure() != null) {
                    FXFigure fxFigure = new FXFigure(tile.getFigure());

                    figures.add(fxFigure);
                    getChildren().add(fxFigure);
                }
            }
        }

        if (game.isGameOver()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(game.getWinner() + " wins!");
            alert.showAndWait();
            Platform.exit();
        }
    }
}
