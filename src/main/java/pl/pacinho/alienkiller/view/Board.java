package pl.pacinho.alienkiller.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JFrame {

    private Board self = this;
    private BoardPanel boardPanel;

    public Board() {
        this.setTitle("Alien Killer");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        init();
        initView();
        initActions();
    }

    private void initView() {
        Container main = this.getContentPane();
        main.add(boardPanel, BorderLayout.CENTER);
    }

    private void init() {
        boardPanel = new BoardPanel();
    }


    private void initActions() {
        self.setFocusable(true);
        self.requestFocusInWindow();
    }

}
