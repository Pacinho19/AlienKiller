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
    private BufferedImage gameOverImage = (BufferedImage) Images.load(ObjectType.GAME_OVER);

    private Board board;
    private GameObject player;

    @Getter
    private List<GameObject> bullets;
    @Getter
    private List<GameObject> aliens;
    private boolean gameOver;

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
        if (!gameOver) {
            drawBackground(g);
            drawGifObject(player, g);
            drawBullets(g);
            drawAliens(g);
            checkCollisionBetweenBulletsAndAliens();
            checkCollisionBetweenAliensAndPlayer();
            Toolkit.getDefaultToolkit().sync();
            return;
        }
        drawGameOver(g);

    }

    private void drawGameOver(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - gameOverImage.getWidth(null)) / 2;
        int y = (this.getHeight() - gameOverImage.getHeight(null)) / 2;
        g2d.drawImage(gameOverImage, x, y, null);
    }

    private void checkCollisionBetweenAliensAndPlayer() {
        if (player == null) {
            return;
        }

        for (GameObject alien : board.getBoardPanel().getAliens()) {
            if (alien.intersects(player)) {
                gameOver = true;
                board.setPlayer(null);
                return;
            }
        }
    }

    private void checkCollisionBetweenBulletsAndAliens() {
        for (GameObject alien : board.getBoardPanel().getAliens()) {
            for (GameObject bullet : board.getBoardPanel().getBullets()) {
                if (alien.intersects(bullet)) {
                    board.getBoardPanel().getBullets().remove(bullet);
                    board.getBoardPanel().getAliens().remove(alien);
                    return;
                }
            }
        }
    }

    private void drawBullets(Graphics g) {
        bullets.forEach(b -> drawGifObject(b, g));
    }

    private void drawAliens(Graphics g) {
        aliens.forEach(b -> drawGifObject(b, g));
    }

    private void drawGifObject(GameObject gameObject, Graphics g) {
        if (gameObject == null) {
            return;
        }
        g.drawImage(gameObject.getIcon().getImage(),
                (int) gameObject.getX(),
                (int) gameObject.getY(),
                (int) gameObject.getWidth(),
                (int) gameObject.getHeight(),
                this);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(
                spaceImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH),
                0, 0, this);
    }

    public void addBullet(int x, int y) {
        GameObject gameObject = new GameObject(x + (int) player.getWidth() + 10, y, 70, 50, ObjectType.BULLET);
        bullets.add(gameObject);
        new BulletThread(board, gameObject).start();
    }
}