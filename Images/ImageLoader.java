package Images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    public BufferedImage whiteBishop;
    public BufferedImage blackPawn;
    public BufferedImage whitePawn;
    public ImageLoader() {
        try {
            whitePawn = ImageIO.read(new File("Pics/WhitePawn.png"));
            blackPawn = ImageIO.read(new File("Pics/BlackPawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
