package GUI;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    static ArrayList <Coordinates> allowed = new ArrayList<Coordinates>();
    private static void switchColor(Graphics2D g2d) {
        if(g2d.getColor() == Color.DARK_GRAY) {
            g2d.setColor(Color.WHITE);
        }
        else {
            g2d.setColor(Color.DARK_GRAY);
        }
    }
    public static void draw(Graphics2D g2d) {
        g2d.setColor(Color.DARK_GRAY);
        for(int j = 0; j < 8; j++) {
            for(int i = 0; i < 8; i++) {
                g2d.fillRect(i*100, j*100,100,100);
                switchColor(g2d);
            }
            switchColor(g2d);
        }
        g2d.setColor(Color.CYAN);
        for(Coordinates c : Board.allowed) {
            g2d.fillRect(c.getX()*100, c.getY()*100,100,100);
        }
    }
}
