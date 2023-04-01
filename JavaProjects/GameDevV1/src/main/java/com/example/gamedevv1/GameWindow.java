package com.example.gamedevv1;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame{
    private JFrame jframe;
    GameWindow(GamePanel gamePanel) {
        this.add(gamePanel);
        this.setTitle("Game Dev Alpha");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addWindowFocusListener(new WindowFocusListener(){
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowLostFocus();

            }
        });
    }
}
