package Game;
import GUI.*;
import Main.*;
public class Knight extends Pieces {
    public Knight(int col, int row, char color) {
        this.col = col;
        this.row = row;
        this.color = color;

        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackKnight;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whiteKnight;
        }
    }
    
    public void movement() {
        int currentRow = row;
        int currentCol = col;
        checkIfAllowedPosition(currentCol + 2, currentRow + 1);
        checkIfAllowedPosition(currentCol + 2, currentRow - 1);
        checkIfAllowedPosition(currentCol + 1, currentRow + 2);
        checkIfAllowedPosition(currentCol + 1, currentRow - 2);
        checkIfAllowedPosition(currentCol - 2, currentRow - 1);
        checkIfAllowedPosition(currentCol - 2, currentRow + 1);
        checkIfAllowedPosition(currentCol - 1, currentRow + 2);
        checkIfAllowedPosition(currentCol - 1, currentRow - 2);
    }

    private void checkIfAllowedPosition(int col, int row) {
        Game game = Main.gui.game;
        if(row <= 7 && row >= 0 && col <= 7 && col >= 0) {
            if(game.getPiece(col, row) == null || game.getPiece(col, row).getColor() != color) {
                Board.allowed.add(new Coordinates(col, row));
            }
        }
    } 
}
