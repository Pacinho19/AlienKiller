package pl.pacinho.alienkiller.logic;

import pl.pacinho.alienkiller.model.ObjectType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {

    private static final BufferedImage space = loadPNG("space.png");
//    private static final BufferedImage player = loadPNG("player.png");
//    private static final BufferedImage alien = loadPNG("alien.png");
//    private static final BufferedImage bullet = loadPNG("bullet.png");

    private static BufferedImage loadPNG(String name) {
        try {
            return ImageIO.read(Images.class.getClassLoader().getResource("img/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage load(ObjectType cellType) {
        switch (cellType) {
            case SPACE:
                return space;
//            case PLAYER:
//                return player;
//            case ALIEN:
//                return alien;
//            case BULLET:
//                return bullet;
        }
        return null;
    }


}
