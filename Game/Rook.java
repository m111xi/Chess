package Game;
import Main.*;
public class Rook extends Pieces {
    public Rook(int col, int row, char color) {
        this.col = col;
        this.row = row;
        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackRook;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whiteRook;
        }
    }
}
