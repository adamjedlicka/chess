package jeda00.chess.ui.terminal;

import jeda00.chess.Color;
import jeda00.chess.Game;
import jeda00.chess.Move;
import jeda00.chess.logic.BasicPlayer;

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

        while (!game.isGameOver()) {
            clearConsole();

            BasicPlayer player = new BasicPlayer(game);
            Move move = player.play().getMove();

            System.out.println(move);

            game.makeMove(move);

            boardRenderer.render(game.getBoard());
        }

        System.out.println((game.getWinner() == Color.WHITE ? "White" : "Black") + " player wins!");
    }

    private void clearConsole() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

}
