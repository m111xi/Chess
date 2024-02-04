package Game;
import Main.*;
public class Pawn extends Pieces{
    public Pawn(int col, int row, char color) {
        this.col = col;
        this.row = row;
        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackPawn;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whitePawn;
        }
    }
}
