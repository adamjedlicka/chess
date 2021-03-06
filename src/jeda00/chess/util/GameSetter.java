package jeda00.chess.util;

import jeda00.chess.Board;
import jeda00.chess.Color;
import jeda00.chess.Coords;
import jeda00.chess.Tile;
import jeda00.chess.figures.*;

import java.util.List;

public class GameSetter {

    public Board emptyBoard() {
        Board board = new Board();
        List<Tile> tiles = board.getTiles();

        for (char row = '8'; row >= '1'; row--) {
            for (char col = 'A'; col <= 'H'; col++) {
                char[] coords = {col, row};

                tiles.add(new Tile(Coords.fromString(new String(coords))));
            }
        }

        return board;
    }

    public Board defaultBoard() {
        Board board = new Board();
        List<Tile> tiles = board.getTiles();

        for (char row = '8'; row >= '1'; row--) {
            for (char col = 'A'; col <= 'H'; col++) {
                char[] coords = {col, row};

                tiles.add(new Tile(Coords.fromString(new String(coords))));
            }
        }

        setWhite(board);
        setBlack(board);

        return board;
    }

    private void addFigureToBoard(Figure figure, Board board) {
        board.getTiles().get(figure.getCoords().getIndex()).setFigure(figure);
    }

    private void setWhite(Board board) {
        addFigureToBoard(new Pawn(board, Color.WHITE, "B2"), board);
        addFigureToBoard(new Pawn(board, Color.WHITE, "A2"), board);
        addFigureToBoard(new Pawn(board, Color.WHITE, "C2"), board);
        addFigureToBoard(new Pawn(board, Color.WHITE, "D2"), board);
        addFigureToBoard(new Pawn(board, Color.WHITE, "E2"), board);
        addFigureToBoard(new Pawn(board, Color.WHITE, "F2"), board);
        addFigureToBoard(new Pawn(board, Color.WHITE, "G2"), board);
        addFigureToBoard(new Pawn(board, Color.WHITE, "H2"), board);

        addFigureToBoard(new Rook(board, Color.WHITE, "A1"), board);
        addFigureToBoard(new Rook(board, Color.WHITE, "H1"), board);

        addFigureToBoard(new Knight(board, Color.WHITE, "B1"), board);
        addFigureToBoard(new Knight(board, Color.WHITE, "G1"), board);

        addFigureToBoard(new Bishop(board, Color.WHITE, "C1"), board);
        addFigureToBoard(new Bishop(board, Color.WHITE, "F1"), board);

        addFigureToBoard(new Queen(board, Color.WHITE, "D1"), board);
        addFigureToBoard(new King(board, Color.WHITE, "E1"), board);

    }

    private void setBlack(Board board) {
        addFigureToBoard(new Pawn(board, Color.BLACK, "A7"), board);
        addFigureToBoard(new Pawn(board, Color.BLACK, "B7"), board);
        addFigureToBoard(new Pawn(board, Color.BLACK, "C7"), board);
        addFigureToBoard(new Pawn(board, Color.BLACK, "D7"), board);
        addFigureToBoard(new Pawn(board, Color.BLACK, "E7"), board);
        addFigureToBoard(new Pawn(board, Color.BLACK, "F7"), board);
        addFigureToBoard(new Pawn(board, Color.BLACK, "G7"), board);
        addFigureToBoard(new Pawn(board, Color.BLACK, "H7"), board);

        addFigureToBoard(new Rook(board, Color.BLACK, "A8"), board);
        addFigureToBoard(new Rook(board, Color.BLACK, "H8"), board);

        addFigureToBoard(new Knight(board, Color.BLACK, "B8"), board);
        addFigureToBoard(new Knight(board, Color.BLACK, "G8"), board);

        addFigureToBoard(new Bishop(board, Color.BLACK, "C8"), board);
        addFigureToBoard(new Bishop(board, Color.BLACK, "F8"), board);

        addFigureToBoard(new Queen(board, Color.BLACK, "D8"), board);
        addFigureToBoard(new King(board, Color.BLACK, "E8"), board);
    }

}
