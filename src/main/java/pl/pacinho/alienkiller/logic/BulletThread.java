package pl.pacinho.alienkiller.logic;

import pl.pacinho.alienkiller.model.GameObject;
import pl.pacinho.alienkiller.view.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BulletThread extends Thread implements ActionListener {

    private Board board;
    private GameObject bullet;

    private Timer timer;

    public BulletThread(Board board, GameObject bullet) {
        this.board = board;
        this.bullet = bullet;
        timer = new Timer(1, this);
    }

    @Override
    public void run() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bullet.setX((int) bullet.getX() + 10);
        if (bullet.getX() + bullet.getWidth() >= board.getWidth()) {
            timer.stop();
            currentThread().interrupt();
            board.getBoardPanel().getBullets().remove(bullet);
        }
        board.refresh();
    }
}