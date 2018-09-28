package jeda00.chess.ui.terminal;

import jeda00.chess.Board;
import jeda00.chess.Color;
import jeda00.chess.Tile;
import jeda00.chess.figures.Figure;
import jeda00.chess.figures.Pawn;

public class BoardRenderer {

    public void render(Board board) {
        for (int row = 0; row < board.DIMENSION; row++) {
            for (int col = 0; col < board.DIMENSION; col++) {
                Tile tile = board.getTiles().get(row * board.DIMENSION + col);
                Figure figure = tile.getFigure();

                if (figure != null) {
                    renderFigure(figure);
                } else if (tile.getColor() == Color.WHITE) {
                    System.out.print("██");
                } else if (tile.getColor() == Color.BLACK) {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public void renderFigure(Figure figure) {
        if(figure.getColor() == Color.BLACK) {
            System.out.print(" ");
        }

        if (figure instanceof Pawn) {
            System.out.print("P");
        }

        if(figure.getColor() == Color.WHITE) {
            System.out.print(" ");
        }
    }

}
