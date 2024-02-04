package GUI;
import Images.ImageLoader;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Game.*;
import Main.*;

public class Game extends JLabel implements Runnable{
    ImageLoader imageLoader = new ImageLoader();
    Thread gameThread;
    ArrayList<Pieces> pieces = new ArrayList<Pieces>();
    Mouse mouse = Main.gui.mouse;
    boolean boolselectedPiece = false;
    Pieces selectedPiece;

    void switchColor(Graphics g) {
        if(g.getColor() == Color.DARK_GRAY) {
            g.setColor(Color.WHITE);
        } 
        else {
            g.setColor(Color.DARK_GRAY);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

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
        pieces.add(new King(4,7,'b'));
        pieces.add(new Bishop(5,7,'b'));
        pieces.add(new Knight(6,7,'b'));
        pieces.add(new Rook(7,7,'b'));

        pieces.add(new Rook(0,0,'w'));
        pieces.add(new Knight(1,0,'w'));
        pieces.add(new Bishop(2,0,'w'));
        pieces.add(new Queen(4,0,'w'));
        pieces.add(new King(3,0,'w'));
        pieces.add(new Bishop(5,0,'w'));
        pieces.add(new Knight(6,0,'w'));
        pieces.add(new Rook(7,0,'w'));




    }
    private void update() {

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
                update();
                repaint();
                delta--;
            }
        }
    }
    public void clickedMouse(int x, int y) {
        int col = x / 100;
        int row = y / 100;
        if(boolselectedPiece) {
            selectedPiece.setCol(col);
            selectedPiece.setRow(row);
            boolselectedPiece = false; 
        }
        else {
            for(Pieces p : pieces) {
                if(p.getRow() == row && p.getCol() == col) {
                    selectedPiece = p;
                    boolselectedPiece = true;
                }
            }
        }
    }

}