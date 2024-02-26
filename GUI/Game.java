package GUI;
import Images.ImageLoader;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Pieces.*;
import Main.*;

public class Game extends JLabel implements Runnable{
    ImageLoader imageLoader = new ImageLoader();
    Thread gameThread;
    ArrayList<Pieces> pieces = new ArrayList<Pieces>();
    Mouse mouse = Main.gui.mouse;
    Pieces selectedPiece;
    Graphics2D g2d;
    char player = 'w';
    King whiteKing;
    King blackKing;

    private void switchPlayer() {
        if(player == 'w') player = 'b';
        else player = 'w';
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D)g;

        //Draw Background
        Board.draw(g2d);

        for(Pieces p : pieces) {
            p.draw(g2d);
        }
        repaint();
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
        blackKing = new King(4,7,'b');
        whiteKing = new King(3,0,'w');

        pieces.add(new Pawn(0,1,'w'));
        pieces.add(new Pawn(1,1,'w'));
        pieces.add(new Pawn(2,1,'w'));
        pieces.add(new Pawn(3,1,'w'));
        pieces.add(new Pawn(4,1,'w'));
        pieces.add(new Pawn(5,1,'w'));
        pieces.add(new Pawn(6,1,'w'));
        pieces.add(new Pawn(7,1,'w'));

        pieces.add(new Pawn(0,6,'b'));
        pieces.add(new Pawn(1,6,'b'));
        pieces.add(new Pawn(2,6,'b'));
        pieces.add(new Pawn(3,6,'b'));
        pieces.add(new Pawn(4,6,'b'));
        pieces.add(new Pawn(5,6,'b'));
        pieces.add(new Pawn(6,6,'b'));
        pieces.add(new Pawn(7,6,'b'));

        pieces.add(new Rook(0,7,'b'));
        pieces.add(new Knight(1,7,'b'));
        pieces.add(new Bishop(2,7,'b'));
        pieces.add(new Queen(3,7,'b'));
        pieces.add(blackKing);
        pieces.add(new Bishop(5,7,'b'));
        pieces.add(new Knight(6,7,'b'));
        pieces.add(new Rook(7,7,'b'));

        pieces.add(new Rook(0,0,'w'));
        pieces.add(new Knight(1,0,'w'));
        pieces.add(new Bishop(2,0,'w'));
        pieces.add(new Queen(4,0,'w'));
        pieces.add(whiteKing);
        pieces.add(new Bishop(5,0,'w'));
        pieces.add(new Knight(6,0,'w'));
        pieces.add(new Rook(7,0,'w'));
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                repaint();
                delta--;
            }
        }
    }
    public void movePiece(int x, int y) {
        int col = x / 100;
        int row = y / 100;
        if(selectedPiece != null) {
            if(checkIfAllowedMove(col,row)) {
                if(getPiece(col,row) != null) {
                    pieces.remove(getPiece(col,row));
                }
                selectedPiece.setCol(col);
                selectedPiece.setRow(row);

                if(checkIfInCheck()) System.out.print("asdasasd-");
                
                selectedPiece = null;
                Board.allowed.clear();
                switchPlayer();
            }
            else {
                selectedPiece = null; 
                Board.allowed.clear();
            }
        }
        else {
            for(Pieces p : pieces) {
                if(p.getRow() == row && p.getCol() == col) {
                    if(p.getColor() == player) {
                        selectedPiece = p;
                        p.movement();
                    }
                }
            }
        }
    }

    private boolean checkIfAllowedMove(int x, int y) {
        for(Coordinates c : Board.allowed) {
            if(c.x == x && c.y == y) return true;
        }
        return false;
    }

    public Pieces getPiece(int col, int row) {
        for(Pieces p : pieces) {
            if(p.getCol() == col && p.getRow() == row) return p;
        }
        return null;
    }
    private boolean checkIfInCheck() {
        Board.switchDraw();
        int col; int row;
        for(Pieces p : pieces) {
            Board.allowed.clear();
            p.movement();

            if(p.getColor() == 'w') {
                col = blackKing.getCol();
                row = blackKing.getRow();
            }
            else {
                col = whiteKing.getCol();
                row = whiteKing.getRow();
            }

            for(Coordinates c : Board.allowed) {
                if(c.x == col && c.y == row) {
                    Board.allowed.clear();
                    Board.switchDraw();
                    return true;
                }
            }
        }
        Board.switchDraw();
        return false;
    }  
}