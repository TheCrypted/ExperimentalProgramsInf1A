
import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel{
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 1024;
    private Game game;
    GamePanel(Game game) {
        this.game = game;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(10, 10, 10, 10);
    }
}
