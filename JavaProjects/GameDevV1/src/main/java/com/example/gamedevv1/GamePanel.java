package com.example.gamedevv1;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Utils.Constants.Directions.*;
import static Utils.Constants.PlayerConstants.*;
import static Utils.Constants.getSpriteAmount;

public class GamePanel extends JPanel {
    static final int SCREEN_WIDTH = 1280;
    static final int SCREEN_HEIGHT = 800;
    private Game game;
    GamePanel(Game game) {
        MouseInputs mouseInputs = new MouseInputs(this);
        this.setPreferredSize(new Dimension(Game.GAME_WIDTH, Game.GAME_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.game = game;
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void updateGame() {
    }

    //    public void updatePosX(int value){
//        xDelta += value;
//        repaint();
//    }
//    public void updatePosY(int value){
//        yDelta += value;
//        repaint();
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
        draw(g);
        repaint();
    }

    public Game getGame() {
        return game;
    }

    public static void draw(Graphics g) {

    }
}



//    static final int SCREEN_WIDTH = 1000;
//    static final int SCREEN_HEIGHT = 800;
//    static final int DELAY = 20;
//    static final int UNIT_SIZE = 20;
//    static char direction = 'X';
//    static boolean up = false;
//    static boolean down = false;
//    static boolean right  = true;
//    static boolean left = false;
//    static boolean running = false;
//
//    static Timer timer;
//    Random random;
//    GamePanel(){
//        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
//        this.setBackground(Color.BLACK);
//        this.setFocusable(true);
//        this.addKeyListener(new KeyListener());
//        startGame();
//    }
//
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        draw(g);
//    }
//    public static void draw(Graphics g){
//        g.setColor(new Color(120, 120, 120));
//        for(int i = 0; i < SCREEN_WIDTH/UNIT_SIZE; i++){
//            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
//            for(int j = 0; j < SCREEN_HEIGHT/UNIT_SIZE; j++){
//                g.drawLine(0, j*UNIT_SIZE, SCREEN_WIDTH, j*UNIT_SIZE);
//            }
//        }
//        switch(direction){
//            case ('L'):
//                g.setColor(Color.BLUE);
//                g.fillRect(UNIT_SIZE * 10, UNIT_SIZE * 10, 2*UNIT_SIZE, 2*UNIT_SIZE);
//                break;
//            case ('R'):
//                g.setColor(Color.PINK);
//                g.fillRect(UNIT_SIZE * 10, UNIT_SIZE * 10, 4*UNIT_SIZE, UNIT_SIZE);
//                break;
//            case ('U'):
//                g.setColor(Color.GREEN);
//                g.fillRect(UNIT_SIZE * 10, UNIT_SIZE * 10, 2*UNIT_SIZE, 2*UNIT_SIZE);
//                break;
//            case ('D'):
//                g.setColor(Color.YELLOW);
//                g.fillRect(UNIT_SIZE * 10, UNIT_SIZE * 10, 2*UNIT_SIZE, 2*UNIT_SIZE);
//                break;
//            case ('X'):
//                g.setColor(new Color(177, 52, 37));
//                g.fillRect(UNIT_SIZE * 10, UNIT_SIZE * 10, 4*UNIT_SIZE, UNIT_SIZE);
//                g.fillRect(UNIT_SIZE * 9, UNIT_SIZE * 11, 8*UNIT_SIZE, UNIT_SIZE);
//                g.setColor(new Color(227, 157, 37));
//                g.fillRect(UNIT_SIZE * 10, UNIT_SIZE * 12, 6*UNIT_SIZE, 5*UNIT_SIZE);
//        }
//
////        if(left){
////            g.setColor(Color.BLUE);
////            g.drawRect(0, 0, 100, 100);
////        } else if(right){
////            g.setColor(Color.RED);
////            g.drawRect(0, 0, 100, 100);
////        }
//
//    }
//
//    public void startGame(){
//        running = true;
//        timer = new Timer(DELAY, this);
//        timer.start();
//    }
//
//    public class KeyListener extends KeyAdapter {
//        @Override
//        public void keyPressed(KeyEvent event){
//            if(event.getKeyCode() == KeyEvent.VK_W) {
//                direction = 'U';
//            } else if(event.getKeyCode() == KeyEvent.VK_S) {
//                direction = 'D';
//            } else if(event.getKeyCode() == KeyEvent.VK_A) {
//                direction = 'L';
//            } else if(event.getKeyCode() == KeyEvent.VK_D) {
//                direction = 'R';
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            if(e.getKeyCode() == KeyEvent.VK_W) {
//                direction = 'X';
//            } else if(e.getKeyCode() == KeyEvent.VK_S) {
//                direction = 'X';
//            } else if(e.getKeyCode() == KeyEvent.VK_A) {
//                direction = 'X';
//            } else if(e.getKeyCode() == KeyEvent.VK_D) {
//                direction = 'X';
//            }
//        }
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(running){
//        }
//        repaint();
//    }
