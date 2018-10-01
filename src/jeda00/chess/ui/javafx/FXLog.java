package jeda00.chess.ui.javafx;

import javafx.scene.control.TextArea;

public class FXLog extends TextArea {

    public FXLog() {
        setPrefWidth(400);
        setEditable(false);
    }

    public void appendText(String text) {
        super.appendText(text + '\n');
    }

}
