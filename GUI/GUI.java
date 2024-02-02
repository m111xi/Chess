package GUI;
import javax.swing.*;

public class GUI {
    JFrame actualJFrame;
    Draw drawingObject;
    public GUI() {
        actualJFrame = new JFrame("Chess");
        actualJFrame.setSize(815, 835);
        actualJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actualJFrame.setLocationRelativeTo(null);
        actualJFrame.setLayout(null);
        actualJFrame.setResizable(false);

        actualJFrame.requestFocus();
        actualJFrame.setVisible(true);
        drawingObject = new Draw();
        drawingObject.setVisible(true);
        drawingObject.setBounds(0,0,800,800);
        actualJFrame.add(drawingObject);
    }


}