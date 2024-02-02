package GUI;
import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    void switchColor(Graphics g) {
        if(g.getColor() == Color.BLACK) {
            g.setColor(Color.WHITE);
        }
        else {
            g.setColor(Color.BLACK);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        g.setColor(Color.BLACK);
        for(int j = 0; j < 8; j++) {
            for(int i = 0; i < 8; i++) {
                g.fillRect(i*100, j*100,100,100);
                switchColor(g);
            }
            switchColor(g);
        }






        //Draw Score

        repaint();

    }

}