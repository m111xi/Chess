package Game;
import Main.*;
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
}