package Inputs;
import com.example.gamedevv1.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Utils.Constants.Directions.*;

public class KeyboardInputs implements KeyListener{
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
        public void keyPressed(KeyEvent event){
            if(event.getKeyCode() == KeyEvent.VK_W) {
                gamePanel.getGame().getPlayer().setUp(true);
            } else if(event.getKeyCode() == KeyEvent.VK_S) {
                gamePanel.getGame().getPlayer().setDown(true);
            } else if(event.getKeyCode() == KeyEvent.VK_A) {
                gamePanel.getGame().getPlayer().setLeft(true);
            } else if(event.getKeyCode() == KeyEvent.VK_D) {
                gamePanel.getGame().getPlayer().setRight(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_W) {
                gamePanel.getGame().getPlayer().setUp(false);
            } else if(e.getKeyCode() == KeyEvent.VK_S) {
                gamePanel.getGame().getPlayer().setDown(false);

            } else if(e.getKeyCode() == KeyEvent.VK_A) {
                gamePanel.getGame().getPlayer().setLeft(false);

            } else if(e.getKeyCode() == KeyEvent.VK_D) {
                gamePanel.getGame().getPlayer().setRight(false);

            }
        }
    }



