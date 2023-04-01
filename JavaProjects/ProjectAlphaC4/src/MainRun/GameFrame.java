package MainRun;

import javax.swing.*;

public class GameFrame extends JFrame {
    GameFrame(GamePanel gamePanel) {
        this.add(gamePanel);
        this.setTitle("Connect Four Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
