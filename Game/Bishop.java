package Game;
import Main.*;
public class Bishop extends Pieces {
    public Bishop(int col, int row, char color) {
        this.col = col;
        this.row = row;
        this.color = color;

        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackBishop;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whiteBishop;
        }
    }
}
