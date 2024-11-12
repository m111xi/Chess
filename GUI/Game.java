package GUI;
import Images.ImageLoader;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Pieces.*;
import Main.*;
//Diese Klasse ist die Main Game Logic Klasse
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

    //Ändert den Spieler, der dran ist
    private void switchPlayer() {
        if(player == 'w') player = 'b';
        else player = 'w';
    }
    //Zeichnet das Brett, sowie die Figuren auf dem Brett
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

    //Gibt den ImageLoader zurück
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    //Startet ein neues Spiel, initialisiert die Figuren
    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
        //Könige sind noch besondere Figuren 
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

    //Game Loop
    @Override
    public void run() {
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

    //Bewegt eine Figur
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

                if(checkIfInCheck()) {
                    System.out.print("asdasasd");
                    
                    if(checkIfInCheckMate()) System.out.print("asdasasdssssss");
                }
                
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

    //Überprüft, ob der Zug valide ist, in dem überprüft wird, ob auf ein markiertes Feld geklickt wurde
    private boolean checkIfAllowedMove(int x, int y) {
        for(Coordinates c : Board.allowed) {
            if(c.x == x && c.y == y) return true;
        }
        return false;
    }

    //Gibt die Figur zurück, auf die geklickt wurde
    public Pieces getPiece(int col, int row) {
        for(Pieces p : pieces) {
            if(p.getCol() == col && p.getRow() == row) return p;
        }
        return null;
    }

    //Überprüft, ob sich zur Zeit ein Schach existiert
    private boolean checkIfInCheck() {
        Board.setDraw(false);
        int col; int row;
        for(int i = 0; i < pieces.size(); i++) { 
            Board.allowed.clear();
            pieces.get(i).movement();

            if(pieces.get(i).getColor() == 'w') {
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
                    Board.setDraw(true);
                    return true;
                }
            }
        }
        Board.setDraw(true);
        return false;
    }  

    //Überprüft ob ein SchachMatt exisitiert
    public boolean checkIfInCheckMate() {
        boolean checkMate = true;
    
        // 1. Überprüfen, ob der König im Schach steht
        if (!checkIfInCheck()) {
            return false; // Nicht im Schach, also kein Schachmatt
        }
    
        // 2. Simuliere jeden möglichen Zug und prüfe, ob es einen Ausweg gibt
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getColor() == player) {
                pieces.get(i).movement();
                int oldRow = pieces.get(i).getRow();
                int oldCol = pieces.get(i).getCol();
    
                // Erstelle eine Kopie von Board.allowed für die Iteration

    
                // Versuche jede mögliche Bewegung der Figur
                switchPlayer();
                ArrayList<Coordinates> possibleMoves = new ArrayList<>(Board.allowed);
                for (Coordinates move : possibleMoves) {
                    pieces.get(i).setRow(move.getY());
                    pieces.get(i).setCol(move.getX());
    
                    // Überprüfe, ob der König immer noch im Schach ist
                    if (!checkIfInCheck()) {
                        checkMate = false;  // Es gibt einen Ausweg, also kein Schachmatt
                    }
    
                    // Setze die Figur auf ihre ursprüngliche Position zurück
                    pieces.get(i).setRow(oldRow);
                    pieces.get(i).setCol(oldCol);
                }
                switchPlayer();
            }
        }
    
        return checkMate;
    }
    
    
}