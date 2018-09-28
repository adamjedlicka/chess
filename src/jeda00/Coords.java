package jeda00;

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
