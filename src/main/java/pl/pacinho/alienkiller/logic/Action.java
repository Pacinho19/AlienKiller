package pl.pacinho.alienkiller.logic;

import pl.pacinho.alienkiller.model.GameObject;
import pl.pacinho.alienkiller.view.Board;

import java.awt.event.KeyEvent;

public class Action {

    private final int moveSize = 10;
    private Board board;
    private GameObject gameObject;

    public Action(Board board) {
        this.board = board;
        gameObject = board.getPlayer();
    }

    public void move(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (gameObject.getX() + (3 * moveSize) + gameObject.getWidth() >= board.getWidth()) {
                return;
            }
            gameObject.setX(gameObject.getX() + moveSize);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (gameObject.getX() == 0) {
                return;
            }
            gameObject.setX(gameObject.getX() - moveSize);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (gameObject.getY() == 0) {
                return;
            }
            gameObject.setY(gameObject.getY() - moveSize);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (gameObject.getY() + (5 * moveSize) + gameObject.getHeight() >= board.getHeight()) {
                return;
            }
            gameObject.setY(gameObject.getY() + moveSize);
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            board.getBoardPanel().addBullet(gameObject.getX(), gameObject.getY());
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            new AlienThread(board).start();
        }
        board.refresh();
    }


}