package pl.pacinho.alienkiller.view;

import pl.pacinho.alienkiller.logic.Images;
import pl.pacinho.alienkiller.model.ObjectType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BoardPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawPlayer(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawPlayer(Graphics g) {

    }

    private final BufferedImage space = Images.load(ObjectType.SPACE);

    private void drawBackground(Graphics g) {
        g.drawImage(
                space.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH),
                0,0,this);
    }
}
