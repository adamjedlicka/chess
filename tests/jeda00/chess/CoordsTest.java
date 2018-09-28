package jeda00.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordsTest {

    Coords coords;

    @Test
    void testFromString() {
        coords = Coords.fromString("A8");
        assertEquals(0, coords.getRow());
        assertEquals(0, coords.getCol());

        coords = Coords.fromString("C7");
        assertEquals(1, coords.getRow());
        assertEquals(2, coords.getCol());
    }

    @Test
    void testToString() {
        coords = Coords.fromString("E3");
        assertEquals("E3", coords.toString());

        coords = Coords.fromString("G1");
        assertEquals("G1", coords.toString());
    }

    @Test
    void testEquals() {
        Coords coords1 = Coords.fromString("F4");
        Coords coords2 = Coords.fromString("F4");

        assertEquals(coords1, coords2);
    }

    @Test
    void testGetColor() {
        coords = Coords.fromString("D4");
        assertEquals(Color.BLACK, coords.getColor());

        coords = Coords.fromString("G6");
        assertEquals(Color.WHITE, coords.getColor());
    }
}