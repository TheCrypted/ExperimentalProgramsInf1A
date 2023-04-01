package Inputs;

import Entity.TestChar;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D){
            gamePanel.getGame().getTestChar().setRight(true);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            gamePanel.getGame().getTestChar().setLeft(true);
        } else if (e.getKeyCode() == KeyEvent.VK_W){
            gamePanel.getGame().getTestChar().setUp(true);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            gamePanel.getGame().getTestChar().setDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D){
            gamePanel.getGame().getTestChar().setRight(false);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            gamePanel.getGame().getTestChar().setLeft(false);
        } else if (e.getKeyCode() == KeyEvent.VK_W){
            gamePanel.getGame().getTestChar().setUp(false);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            gamePanel.getGame().getTestChar().setDown(false);
        }

    }
}
