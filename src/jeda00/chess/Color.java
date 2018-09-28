package jeda00.chess;

public enum Color {
    WHITE(true),
    BLACK(false);

    private final boolean isWhite;

    private Color(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public Color opposite() {
        if (isWhite) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
