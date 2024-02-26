package Images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    public BufferedImage whiteBishop;
    public BufferedImage blackBishop;
    public BufferedImage blackPawn;
    public BufferedImage whitePawn;
    public BufferedImage whiteQueen;
    public BufferedImage blackQueen;
    public BufferedImage whiteKnight;
    public BufferedImage blackKnight;
    public BufferedImage whiteRook;
    public BufferedImage blackRook;
    public BufferedImage whiteKing;
    public BufferedImage blackKing;


    public ImageLoader() {
        try {
            whitePawn = ImageIO.read(new File("Pics/WhitePawn.png"));
            blackPawn = ImageIO.read(new File("Pics/BlackPawn.png"));
            whiteKing = ImageIO.read(new File("Pics/WhiteKing.png"));
            blackKing = ImageIO.read(new File("Pics/BlackKing.png"));
            whiteQueen = ImageIO.read(new File("Pics/WhiteQueen.png"));
            blackQueen = ImageIO.read(new File("Pics/BlackQueen.png"));
            whiteBishop = ImageIO.read(new File("Pics/WhiteBishop.png"));
            blackBishop = ImageIO.read(new File("Pics/BlackBishop.png"));
            whiteKnight = ImageIO.read(new File("Pics/WhiteKnight.png"));
            blackKnight = ImageIO.read(new File("Pics/BlackKnight.png"));
            whiteRook = ImageIO.read(new File("Pics/WhiteRook.png"));
            blackRook = ImageIO.read(new File("Pics/BlackRook.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
