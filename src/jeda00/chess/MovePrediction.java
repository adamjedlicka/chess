package jeda00.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovePrediction {

    private List<Move> moves;

    public MovePrediction(Move move) {
        this.moves = new ArrayList<>();

        addMove(move);
    }

    public void addMove(Move move) {
        moves.add(0, move);
    }

    public Move getMove() {
        return moves.get(0);
    }

    public int getValueFor(Color color) {
        int value = 0;

        for (Move move : moves) {
            if (move.getPlayerColor() == color) {
                value += move.getValue();
            } else {
                value -= move.getValue();
            }
        }

        return value;
    }

    public String toString() {
        return " -> " + moves.stream()
                .map(move -> move.toString())
                .collect(Collectors.joining("\n -> "));
    }

}
