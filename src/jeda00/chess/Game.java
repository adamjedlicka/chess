package jeda00.chess;

public class Game {

    private final Board board;

    private Color activePlayer;

    public Game() {
        this.board = new Board();
        this.activePlayer = Color.WHITE;
    }

    public Board getBoard() {
        return board;
    }

}
