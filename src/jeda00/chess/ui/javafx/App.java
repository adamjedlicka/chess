package jeda00.chess.ui.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jeda00.chess.*;
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
        FXLog fxLog = new FXLog();

        fxBoard.setOnMoveEnd(moveEndEvent -> {
            new Thread(() -> {
                BasicPlayer player = new BasicPlayer(game);
                try {
                    MovePrediction movePrediction = player.play();
                    game.makeMove(movePrediction.getMove());
                    Platform.runLater(() -> {
                        fxBoard.update();
                        fxLog.appendText("=> Prediction value: " + movePrediction.getValueFor(Color.BLACK));
                        fxLog.appendText(movePrediction.toString());
                    });
                } catch (IllegalMoveException e) {
                    System.err.println(e);
                }
            }).start();
        });


        borderPane.setCenter(fxBoard);
        borderPane.setRight(fxLog);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(borderPane, 1200, 800));
        primaryStage.setTitle("Chess by Adam Jedlička");
        primaryStage.show();
    }
}
