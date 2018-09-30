package jeda00.chess.ui.javafx.events;

import javafx.event.Event;
import javafx.event.EventType;

public class MoveEndEvent extends Event {

    public static final EventType<MoveEndEvent> TYPE = new EventType<>("MOVE_END_EVENT");

    public MoveEndEvent() {
        super(TYPE);
    }

}
