package jeda00.chess.ui.terminal;

import jeda00.chess.Game;

public class UI {

    private Game game;

    private BoardRenderer boardRenderer;

    public UI(Game game) {
        System.out.println("Initializing terminal ui...");

        this.game = game;
        this.boardRenderer = new BoardRenderer();
    }

    public void handle() {
        boardRenderer.render(game.getBoard());
    }

}
