package GUI;
import javax.swing.*;

public class GUI {
    JFrame actualJFrame;
    public Game game;
    public Mouse mouse = new Mouse();
    public GUI() {
        SwingUtilities.invokeLater(() -> {

        actualJFrame = new JFrame("Chess");
        actualJFrame.setSize(815, 840);
        actualJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actualJFrame.setLocationRelativeTo(null);
        actualJFrame.setLayout(null);
        actualJFrame.setResizable(false);

        actualJFrame.requestFocus();
        actualJFrame.setVisible(true);
        actualJFrame.addMouseListener(mouse);
        game = new Game();
        game.launchGame();
        game.setVisible(true);
        game.setBounds(0,0,815,840);
        actualJFrame.add(game);
        });
    }


}