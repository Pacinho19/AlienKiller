package pl.pacinho.alienkiller.view;

import lombok.Getter;
import pl.pacinho.alienkiller.logic.BulletThread;
import pl.pacinho.alienkiller.logic.Images;
import pl.pacinho.alienkiller.model.GameObject;
import pl.pacinho.alienkiller.model.ObjectType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {

    private final BufferedImage spaceImage = (BufferedImage) Images.load(ObjectType.SPACE);

    private Board board;
    private GameObject player;

    @Getter
    private List<GameObject> bullets;
    @Getter
    private List<GameObject> aliens;

    public BoardPanel(Board board) {
        this.board = board;
        player = board.getPlayer();
        bullets = new ArrayList<>();
        aliens = new ArrayList<>();
        this.setDoubleBuffered(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawGifObject(player, g);
        drawBullets(g);
        drawAliens(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawBullets(Graphics g) {
        bullets.forEach(b -> drawGifObject(b, g));
    }

    private void drawAliens(Graphics g) {
        aliens.forEach(b -> drawGifObject(b, g));
    }
    private void drawGifObject(GameObject gameObject, Graphics g) {
        g.drawImage(gameObject.getIcon().getImage(),
                gameObject.getX(),
                gameObject.getY(),
                gameObject.getWidth(),
                gameObject.getHeight(),
                this);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(
                spaceImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH),
                0, 0, this);
    }

    public void addBullet(int x, int y) {
        GameObject gameObject = new GameObject(x + player.getWidth() + 10, y, 70, 50, ObjectType.BULLET);
        bullets.add(gameObject);
        new BulletThread(board, gameObject).start();
    }
}