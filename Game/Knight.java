package Game;
import Main.*;
public class Knight extends Pieces {
    public Knight(int col, int row, char color) {
        this.col = col;
        this.row = row;
        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackKnight;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whiteKnight;
        }
    }
}
