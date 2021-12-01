package pl.pacinho.alienkiller.view;

import lombok.Getter;
import pl.pacinho.alienkiller.model.Player;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private Board self = this;
    private BoardPanel boardPanel;

    @Getter
    private Player player;

    public Board() {
        this.setTitle("Alien Killer");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        player = new Player(10, this.getHeight()/2);
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
