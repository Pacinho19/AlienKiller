package pl.pacinho.alienkiller.logic;

import pl.pacinho.alienkiller.model.GameObject;
import pl.pacinho.alienkiller.view.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlienMoveThread extends Thread implements ActionListener {

    private Board board;
    private GameObject alien;
    private Timer timer;

    public AlienMoveThread(Board board, GameObject alien) {
        this.board = board;
        this.alien = alien;
        timer = new Timer(100, this);
    }

    @Override
    public void run() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        alien.setX(alien.getX() - 10);
        if (alien.getX() == 0) {
            timer.stop();
            currentThread().interrupt();
            board.getBoardPanel().getAliens().remove(alien);
        }
        board.refresh();
    }
}