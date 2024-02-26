package Game;
import Main.*;
import GUI.*;
public class Rook extends Pieces {
    public Rook(int col, int row, char color) {
        this.col = col;
        this.row = row;
        this.color = color;

        if(color == 'b') {
            this.image = Main.gui.game.getImageLoader().blackRook;
        }
        else {
            this.image = Main.gui.game.getImageLoader().whiteRook;
        }
    }

    @Override
    public void movement() {
        Game game = Main.gui.game;
        int currentCol = col;
        int currentRow = row;
        currentRow++;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentRow++;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));

        currentRow = row;
        currentCol = col;
        currentRow--;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentRow--;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));

        currentRow = row;
        currentCol = col;
        currentCol++;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentCol++;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));

        currentRow = row;
        currentCol = col;
        currentCol--;
        while(game.getPiece(currentCol, currentRow) == null && currentRow <= 7 && currentRow >= 0 && currentCol <= 7 && currentCol >= 0) {
            Board.allowed.add(new Coordinates(currentCol, currentRow));
            currentCol--;
        }
        if(game.getPiece(currentCol, currentRow) != null && game.getPiece(currentCol, currentRow).getColor() != color) Board.allowed.add(new Coordinates(currentCol, currentRow));
    }
}
