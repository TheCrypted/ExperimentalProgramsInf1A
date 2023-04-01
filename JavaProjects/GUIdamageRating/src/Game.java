import javax.swing.*;

public class Game {
    private GamePanel gamePanel;
    private GameFrame gameFrame;
    Game(){
        gamePanel = new GamePanel(this);
        gameFrame = new GameFrame(gamePanel);
        JLabel label = new JLabel("test", SwingConstants.CENTER);
        gameFrame.add(label);
    }
}
