package jeda00.chess;

import jeda00.chess.util.GameSetter;

import java.util.List;

public class Board {

    public static final int DIMENSION = 8;

    private List<Tile> tiles;

    public Board() {
        this.tiles = (new GameSetter()).defaultGame();
    }

}

