package Game;
import Main.*;
public class Queen extends Pieces {
    public Queen(int col, int row, char color) {
        this.col = col;
        this.row = row;
        this.color = color;

        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackQueen;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whiteQueen;
        }
    }
}
