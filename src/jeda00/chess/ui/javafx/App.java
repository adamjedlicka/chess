package jeda00.chess.ui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jeda00.chess.Game;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();

        BorderPane borderPane = new BorderPane();

        FXBoard fxBoard = new FXBoard(game);

        borderPane.setCenter(fxBoard);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(borderPane, 800, 800));
        primaryStage.setTitle("Chess by Adam Jedlička");
        primaryStage.show();
    }
}
