package jeda00.chess;

final public class Coords {

    private final int row;

    private final int col;

    public Coords(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Coords fromString(String coords) {
        char rowChar = coords.charAt(1);
        char colChar = coords.charAt(0);

        int rowInt = 8 - (rowChar - '0');
        int colInt = (colChar - 'A');

        return new Coords(rowInt, colInt);
    }

    public Coords moveUpBy(int by) {
        return new Coords(row - by, col);
    }

    public Coords moveDownBy(int by) {
        return new Coords(row + by, col);
    }

    public Coords moveLeftBy(int by) {
        return new Coords(row, col - by);
    }

    public Coords moveRightBy(int by) {
        return new Coords(row, col + by);
    }

    public boolean inBounds() {
        return row >= 0 && col >= 0 && row <= 8 && col <= 8;
    }

    public Color getColor() {
        if (row % 2 == 0) {
            return col % 2 == 0 ? Color.WHITE : Color.BLACK;
        } else {
            return col % 2 == 0 ? Color.BLACK : Color.WHITE;
        }
    }

    public int getIndex() {
        return (row * 8) + col;
    }

    @Override
    public String toString() {
        char[] coords = {(char) (col + 'A'), (char) (8 - (row) + '0')};

        return new String(coords);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coords)) {
            return false;
        }

        return ((Coords) o).row == row && ((Coords) o).col == col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
