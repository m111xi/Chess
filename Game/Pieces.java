package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Pieces {
    int row;
    int col;
    BufferedImage image;
    char color;

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public char getColor() {
        return this.color;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, col * 100, row * 100, 100, 100, null);
    }
}
