package GUI;
import Images.ImageLoader;
import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {
    ImageLoader imageLoader = new ImageLoader();

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


        //Draw Background
        g.setColor(Color.DARK_GRAY);
        for(int j = 0; j < 8; j++) {
            for(int i = 0; i < 8; i++) {
                g.fillRect(i*100, j*100,100,100);
                switchColor(g);
            }
            switchColor(g);
        }

        if (imageLoader.whitePawn != null) {
            g.drawImage(imageLoader.whitePawn, 0, 0, 30,30, null);
        } else {
            System.out.println("Black pawn image is null!");
        }
        

        g.drawImage(imageLoader.blackPawn, 100, 0, 30,30, null);




        //Draw Score

        repaint();

    }

}