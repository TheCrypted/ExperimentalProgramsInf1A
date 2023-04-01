package main;

import javax.swing.*;
import java.awt.*;

import Entity.TestChar;
import Inputs.KeyboardInputs;
import java.awt.event.*;
import Inputs.MouseInputs;
import Utils.LoadSave;


public class GamePanel extends JPanel {
    private static final int GAME_WIDTH = 681;
    private static final int GAME_HEIGHT = 687;
    private static final int DELAY = 20;
    private int x = 0;
    private int y = 0;
    private Game game;
    GamePanel(Game game){
        this.game = game;
        KeyboardInputs keyboardInputs = new KeyboardInputs(this);
        MouseInputs mouseInputs = new MouseInputs(this);
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
//        repaint();
    }
    public void draw(Graphics g) {
        game.update();
        g.drawImage(LoadSave.getPlayerAtlas(LoadSave.LEVEL_ATLAS), 0, 0, null);
        game.render(g);

//        g.setColor(Color.RED);
//        g.fillRect(game.getTestChar().getX(), game.getTestChar().getY(), 100, 100);
    }


    public Game getGame() {

        return game;
    }
}
