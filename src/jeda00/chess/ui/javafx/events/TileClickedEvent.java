package jeda00.chess.ui.javafx.events;

import javafx.event.Event;
import javafx.event.EventType;
import jeda00.chess.Coords;

public class TileClickedEvent extends Event {

    public static EventType<TileClickedEvent> TYPE = new EventType<>("TILE_CLICKED_EVENT");

    private Coords coords;

    public TileClickedEvent(Coords coords) {
        super(TYPE);

        this.coords = coords;
    }

    public Coords getCoords() {
        return coords;
    }
}
