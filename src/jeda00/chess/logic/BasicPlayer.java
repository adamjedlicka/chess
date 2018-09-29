package jeda00.chess.logic;

import jeda00.chess.*;
import jeda00.chess.ui.terminal.BoardRenderer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BasicPlayer {

    private Game game;

    public BasicPlayer(Game game) {
        this.game = game;
    }

    public Move play() throws IllegalMoveException {
        MovePrediction prediction = predictPlay(game, 4);

        System.out.println(prediction);
        System.out.println("Prediction value for " + game.getActivePlayerColor() + ": " + prediction.getValueFor(game.getActivePlayerColor()));

        return prediction.getMove();
    }

    private MovePrediction predictPlay(Game game, int steps) throws IllegalMoveException {
        if (steps <= 0) {
            return new MovePrediction(getBestMove(game));
        }

        Color playerColor = game.getActivePlayerColor();

        List<Move> possibleMoves = game.getActiveFigures().stream()
                .flatMap(figure -> figure.getPossibleMoves().stream())
                .collect(Collectors.toList());

        MovePrediction bestPrediction = null;

        for (Move move : possibleMoves) {
            Game _game = new Game(game);
            _game.makeMove(move);

            MovePrediction prediction = predictPlay(_game, steps - 1);
            prediction.addMove(move);

            if (bestPrediction == null || prediction.getValueFor(playerColor) > bestPrediction.getValueFor(playerColor)) {
                bestPrediction = prediction;
            }
        }

        return bestPrediction;
    }

    private Move getBestMove(Game game) {
        List<Move> bestMoves = game.getActiveFigures().stream()
                .map(figure -> figure.getBestMove())
                .filter(move -> move != null)
                .collect(Collectors.toList());

        Collections.sort(bestMoves);

        return bestMoves.get(0);
    }

}
