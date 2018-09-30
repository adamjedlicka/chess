package jeda00.chess;

import java.util.Arrays;
import java.util.List;

public class Direction {

    private final int vertical;

    private final int horizontal;

    public Direction(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public static Direction up() {
        return new Direction(-1, 0);
    }

    public static Direction down() {
        return new Direction(1, 0);
    }

    public static Direction left() {
        return new Direction(0, -1);
    }

    public static Direction right() {
        return new Direction(0, 1);
    }

    public static Direction upAndLeft() {
        return new Direction(-1, -1);
    }

    public static Direction downAndLeft() {
        return new Direction(1, -1);
    }

    public static Direction upAndRight() {
        return new Direction(-1, 1);
    }

    public static Direction downAndRight() {
        return new Direction(1, 1);
    }

    public static List<Direction> straight() {
        return Arrays.asList(up(), down(), left(), right());
    }

    public static List<Direction> diagonal() {
        return Arrays.asList(upAndLeft(), downAndLeft(), upAndRight(), downAndRight());
    }

    public static List<Direction> straightAndDiagonal() {
        return Arrays.asList(up(), down(), left(), right(), upAndLeft(), downAndLeft(), upAndRight(), downAndRight());
    }

}
