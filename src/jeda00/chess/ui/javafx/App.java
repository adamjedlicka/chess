package jeda00.chess.ui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jeda00.chess.Game;
import jeda00.chess.IllegalMoveException;
import jeda00.chess.Move;
import jeda00.chess.logic.BasicPlayer;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();

        BorderPane borderPane = new BorderPane();

        FXBoard fxBoard = new FXBoard(game);
        fxBoard.setOnMoveEnd(moveEndEvent -> {
            BasicPlayer player = new BasicPlayer(game);
            try {
                Move move = player.play();
                game.makeMove(move);
                fxBoard.update();
            } catch (IllegalMoveException e) {
                System.err.println(e);
            }
        });


        borderPane.setCenter(fxBoard);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(borderPane, 800, 800));
        primaryStage.setTitle("Chess by Adam Jedlička");
        primaryStage.show();
    }
}
