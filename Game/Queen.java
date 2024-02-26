package Game;
import GUI.Board;
import GUI.Coordinates;
import GUI.Game;
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

    @Override
    public void movement() {
        rookMovement();
        kingMovement();
        bishopMovement();
    }

    private void rookMovement() {
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

    private void kingMovement() {
        int currentRow = row;
        int currentCol = col;
        checkIfAllowedPosition(currentCol, currentRow + 1, color);
        checkIfAllowedPosition(currentCol, currentRow - 1, color);
        checkIfAllowedPosition(currentCol + 1, currentRow + 1, color);
        checkIfAllowedPosition(currentCol + 1, currentRow - 1, color);
        checkIfAllowedPosition(currentCol - 1, currentRow - 1, color);
        checkIfAllowedPosition(currentCol - 1, currentRow + 1, color);
        checkIfAllowedPosition(currentCol - 1, currentRow, color);
        checkIfAllowedPosition(currentCol + 1, currentRow, color);
    }

    private void checkIfAllowedPosition(int col, int row, char color) {
        Game game = Main.gui.game;
        if(row <= 7 && row >= 0 && col <= 7 && col >= 0) {
            if(game.getPiece(col, row) == null || game.getPiece(col, row).getColor() != color) {
                Board.allowed.add(new Coordinates(col, row));
            }
        }
    }

    private void bishopMovement(){
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
