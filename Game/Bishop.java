package Game;
import GUI.*;
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
    @Override
    public void movement(){
        Game game = Main.gui.game;
        int currentRow = row;
        int currentCol = col;
        currentCol++;
        currentRow++;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentCol++;
            currentRow++;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));

        currentRow = row;
        currentCol = col;
        currentCol++;
        currentRow--;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentCol++;
            currentRow--;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));

        currentRow = row;
        currentCol = col;
        currentCol--;
        currentRow++;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentCol--;
            currentRow++;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));

        currentRow = row;
        currentCol = col;
        currentCol--;
        currentRow--;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentCol--;
            currentRow--;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));
    }
}
