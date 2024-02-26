package Pieces;
import GUI.Board;
import GUI.Coordinates;
import Main.*;
import GUI.Game;
public class King extends Pieces {
    public King(int col, int row, char color) {
        this.col = col;
        this.row = row;
        this.color = color;

        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackKing;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whiteKing;
        }
    }
    @Override
    public void movement() {
        int currentRow = row;
        int currentCol = col;
        checkIfAllowedPosition(currentCol, currentRow + 1, color);
        checkIfAllowedPosition(currentCol, currentRow - 1, color);
        checkIfAllowedPosition(currentCol + 1, currentRow + 1, color);
        checkIfAllowedPosition(currentCol + 1, currentRow - 1, color);
        checkIfAllowedPosition(currentCol - 1, currentRow - 1, color);
        checkIfAllowedPosition(currentCol - 1, currentRow + 1, color);
        checkIfAllowedPosition(currentCol - 1, currentRow, color);
        checkIfAllowedPosition(currentCol + 1, currentRow, color);
    }
    private void checkIfAllowedPosition(int col, int row, char color) {
        Game game = Main.gui.game;
        if(row <= 7 && row >= 0 && col <= 7 && col >= 0) {
            if(game.getPiece(col, row) == null || game.getPiece(col, row).getColor() != color) {
                Board.allowed.add(new Coordinates(col, row));
            }
        }
    }
}