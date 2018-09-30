package jeda00.chess.ui.javafx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeda00.chess.figures.Figure;

public class FXFigure extends ImageView {

    private final Figure figure;

    public FXFigure(Figure figure) {
        this.figure = figure;

        Image image = new Image(getPath());
        setImage(image);

        setFitHeight(FXTile.SIZE);
        setFitWidth(FXTile.SIZE);

        setX(figure.getCoords().getCol() * FXTile.SIZE);
        setY(figure.getCoords().getRow() * FXTile.SIZE);
    }

    public String getPath() {
        String color = figure.isWhite() ? "white" : "black";
        String type = figure.getClass().getSimpleName();

        return "/figures/" + color + type + ".png";
    }

    public Figure getFigure() {
        return figure;
    }

}
