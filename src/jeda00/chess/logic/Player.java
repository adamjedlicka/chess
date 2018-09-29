package jeda00.chess.logic;

import jeda00.chess.Coords;
import jeda00.chess.Game;
import jeda00.chess.Move;
import jeda00.chess.figures.Figure;

import java.util.List;
import java.util.Random;

public class Player {

    private final Game game;

    public Player(Game game) {
        this.game = game;
    }

    public void randomMove() {
        List<Figure> figures = game.getActiveFigures();
        Figure figure = figures.get(new Random().nextInt(figures.size()));
        List<Move> possibleMoves = figure.getPossibleMoves();
        Move move = possibleMoves.get(new Random().nextInt(possibleMoves.size()));

        game.moveFigure(figure, move.getTo());
    }

}
