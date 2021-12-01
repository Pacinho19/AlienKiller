package pl.pacinho.alienkiller.view;

import lombok.Getter;
import pl.pacinho.alienkiller.logic.Action;
import pl.pacinho.alienkiller.model.GameObject;
import pl.pacinho.alienkiller.model.ObjectType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JFrame {

    private Board self = this;

    @Getter
    private BoardPanel boardPanel;

    @Getter
    private GameObject player;

    private Action action;

    public Board() {
        this.setTitle("Alien Killer");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        player = new GameObject(10, this.getHeight() / 2, 50, 50, ObjectType.PLAYER);
        action = new Action(this);

        init();
        initView();
        initActions();
    }

    private void initView() {
        Container main = this.getContentPane();
        main.add(boardPanel, BorderLayout.CENTER);
    }

    private void init() {
        boardPanel = new BoardPanel(this);
    }


    private void initActions() {
        self.setFocusable(true);
        self.requestFocusInWindow();
        self.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                action.move(e);
            }
        });
    }

    public void refresh() {
        self.repaint();
        self.revalidate();
        self.validate();
    }

}