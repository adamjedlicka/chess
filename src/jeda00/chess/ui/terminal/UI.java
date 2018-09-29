package jeda00.chess.ui.terminal;

import jeda00.chess.Game;
import jeda00.chess.Move;
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
        boardRenderer.render(game.getBoard());

        while (true) {
            Thread.sleep(1000);
            clearConsole();

            Player player = new Player(game);
            Move move = player.bestOrRandomMove();

            System.out.println(move);

            game.makeMove(move);

            boardRenderer.render(game.getBoard());
        }
    }

    private void clearConsole() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

}
