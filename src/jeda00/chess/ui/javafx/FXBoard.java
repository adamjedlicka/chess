package jeda00.chess.ui.javafx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import jeda00.chess.*;
import jeda00.chess.figures.Figure;
import jeda00.chess.ui.javafx.events.MoveEndEvent;

import java.util.List;
import java.util.stream.Collectors;

public class FXBoard extends Pane {

    private Game game;

    private Figure activeFigure;

    public FXBoard(Game game) {
        this.game = game;

        update();

        setOnMouseClicked(this::onMouseClicked);
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        int col = (int) mouseEvent.getX() / FXTile.SIZE;
        int row = (int) mouseEvent.getY() / FXTile.SIZE;
        Coords coords = new Coords(row, col);

        getTiles().forEach(fxTile -> fxTile.deactivate());

        if (activeFigure != null && activeFigure.canMoveTo(coords)) {
            try {
                game.makeMove(activeFigure.moveTo(coords));
            } catch (IllegalMoveException e) {
                System.err.println(e);
            }

            activeFigure = null;

            update();

            fireEvent(new MoveEndEvent());
        } else {
            FXTile fxTile = getTile(coords);
            Figure figure = fxTile.getFigure();

            if (figure != null && figure.getColor() == game.getActivePlayerColor()) {
                activeFigure = figure;

                fxTile.activate();

                activeFigure.getPossibleMoves().forEach(move -> getTile(move.getTo()).activate());
            }
        }
    }

    public void update() {
        getChildren().clear();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Coords coords = new Coords(row, col);
                Tile tile = game.getBoard().getTile(coords);

                FXTile fxTile = new FXTile(game.getBoard().getTile(coords));
                getChildren().add(fxTile);

                if (tile.getFigure() != null) {
                    FXFigure fxFigure = new FXFigure(tile.getFigure());
                    getChildren().add(fxFigure);
                }
            }
        }
    }

    public void setOnMoveEnd(EventHandler<MoveEndEvent> handler) {
        addEventHandler(MoveEndEvent.TYPE, handler);
    }

    public List<FXTile> getTiles() {
        return getChildren().stream()
                .filter(node -> node instanceof FXTile)
                .map(node -> (FXTile) node)
                .collect(Collectors.toList());
    }

    public FXTile getTile(Coords coords) {
        return getTiles().stream()
                .filter(fxTile -> fxTile.getCoords().equals(coords))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<FXFigure> getFigures() {
        return getChildren().stream()
                .filter(node -> node instanceof FXFigure)
                .map(node -> (FXFigure) node)
                .collect(Collectors.toList());
    }
}
