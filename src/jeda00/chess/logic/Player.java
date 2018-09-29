package jeda00.chess.logic;

import jeda00.chess.Game;
import jeda00.chess.Move;
import jeda00.chess.figures.Figure;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Player {

    private final Game game;

    public Player(Game game) {
        this.game = game;
    }

    public Move randomMove() {
        List<Figure> figures = game.getActiveFigures();
        Figure figure = figures.get(new Random().nextInt(figures.size()));
        List<Move> possibleMoves = figure.getPossibleMoves();
        return possibleMoves.get(new Random().nextInt(possibleMoves.size()));
    }

    public Move bestOrRandomMove() {
        List<Move> bestMoves = game.getActiveFigures().stream()
                .map(figure -> figure.getBestMove())
                .filter(move -> move != null)
                .collect(Collectors.toList());

        Collections.sort(bestMoves);

        return bestMoves.get(0);
    }

}
