package jeda00.chess.ui.terminal;

import jeda00.chess.Game;
import jeda00.chess.logic.Player;

public class UI {

    private Game game;

    private BoardRenderer boardRenderer;

    public UI(Game game) {
        System.out.println("Initializing terminal ui...");

        this.game = game;
        this.boardRenderer = new BoardRenderer();
    }

    public void handle() throws Exception {
        while (true) {
            clearConsole();

            boardRenderer.render(game.getBoard());

            Player player = new Player(game);
            player.bestOrRandomMove();

            Thread.sleep(1000);
        }
    }

    private void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

}
