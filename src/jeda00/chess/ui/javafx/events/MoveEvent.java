package jeda00.chess.ui.javafx.events;

import javafx.event.Event;
import javafx.event.EventType;
import jeda00.chess.Move;

public class MoveEvent extends Event {

    public static final EventType<MoveEvent> TYPE = new EventType<>("MOVE_EVENT");

    private final Move move;

    public MoveEvent(Move move) {
        super(TYPE);

        this.move = move;
    }

    public Move getMove() {
        return move;
    }

}
