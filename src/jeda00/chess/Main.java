package jeda00.chess;

import jeda00.chess.ui.terminal.UI;

public class Main {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        UI ui = new UI(game);

        ui.handle();
    }

}
