package Pieces;
import GUI.*;
import Main.*;
public class Pawn extends Pieces{
    public Pawn(int col, int row, char color) {
        this.col = col;
        this.row = row;
        this.color = color;
        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackPawn;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whitePawn;
        }
    }
    public void movement() {
        Game game = Main.gui.game;
        if(color == 'b') {
             if(row == 6) {
                 if(game.getPiece(col, row - 1) == null) {
                     Board.allowed.add(new Coordinates(col, row - 1));
                     if(game.getPiece(col, row - 2) == null) {
                         Board.allowed.add(new Coordinates(col, row - 2));
                     }
                 }
             }
             else {
                 if(game.getPiece(col, row - 1) == null) {
                     Board.allowed.add(new Coordinates(col, row - 1));
                 }
             }
             if(game.getPiece(col - 1, row - 1) != null && game.getPiece(col - 1, row - 1).getColor() != 'b') Board.allowed.add(new Coordinates(col - 1, row -1));
             if(game.getPiece(col + 1, row - 1) != null && game.getPiece(col + 1, row - 1).getColor() != 'b') Board.allowed.add(new Coordinates(col + 1, row -1));
         }
        else {
             if(row == 1) {
                 if(game.getPiece(col, row + 1) == null) {
                     Board.allowed.add(new Coordinates(col, row +1));
                     if(game.getPiece(col,row + 2) == null) {
                         Board.allowed.add(new Coordinates(col, row + 2));
                     }
                 }
             }
             else {
                 if(game.getPiece(col, row + 1) == null) {
                     Board.allowed.add(new Coordinates(col, row +1));
                 }
             }
             if(game.getPiece(col - 1, row + 1) != null && game.getPiece(col - 1, row + 1).getColor() != 'w') Board.allowed.add(new Coordinates(col - 1, row + 1));
             if(game.getPiece(col + 1, row + 1) != null && game.getPiece(col + 1, row + 1).getColor() != 'w') Board.allowed.add(new Coordinates(col + 1, row +1 ));
         }
    }
}
