package GUI;
import Main.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter{
    public int x, y;
    public boolean pressed;

    @Override
    public void mousePressed(MouseEvent e) {
        Main.gui.game.clickedMouse(e.getX(), e.getY());
    }
}
