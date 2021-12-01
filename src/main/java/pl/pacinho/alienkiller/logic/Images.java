package pl.pacinho.alienkiller.logic;

import pl.pacinho.alienkiller.model.ObjectType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Images {

    private static final BufferedImage space = loadPNG("space.png");
    private static final ImageIcon player = loadGIF("player3.gif");
    private static final ImageIcon bullet = loadGIF("bullet2.gif");
    private static final ImageIcon alien = loadGIF("alien.gif");

    private static BufferedImage loadPNG(String name) {
        try {
            return ImageIO.read(Images.class.getClassLoader().getResource("img/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ImageIcon loadGIF(String name) {
        URL url = Images.class.getClassLoader().getResource("gif/" + name);
        ImageIcon imageIcon = new ImageIcon(url);
        return imageIcon;
    }



    public static Object load(ObjectType cellType) {
        switch (cellType) {
            case SPACE:
                return space;
            case PLAYER:
                return player;
            case BULLET:
                return bullet;
            case ALIEN:
                return alien;
        }
        return null;
    }


}