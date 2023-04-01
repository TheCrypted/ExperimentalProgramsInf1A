import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
public class GameFrame extends JFrame {
    GameFrame(GamePanel gamePanel){
        this.add(gamePanel);
        this.setTitle("Car Damage Assessment");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
