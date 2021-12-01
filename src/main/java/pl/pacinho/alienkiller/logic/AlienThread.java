package pl.pacinho.alienkiller.logic;

import pl.pacinho.alienkiller.model.GameObject;
import pl.pacinho.alienkiller.model.ObjectType;
import pl.pacinho.alienkiller.utils.RandomUtils;
import pl.pacinho.alienkiller.view.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlienThread extends Thread implements ActionListener {

    private Board board;

    private Timer timer;

    public AlienThread(Board board) {
        this.board = board;
        timer = new Timer(2_000, this);
    }

    @Override
    public void run() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameObject alien = new GameObject(board.getWidth() - 10, RandomUtils.getInt(0, board.getHeight() - 50), 80, 80, ObjectType.ALIEN);
        board.getBoardPanel()
                .getAliens()
                .add(alien);
        new AlienMoveThread(board, alien).start();

    }
}