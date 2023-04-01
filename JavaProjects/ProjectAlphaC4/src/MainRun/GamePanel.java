package MainRun;

import Entities.Clouds;
import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import Resources.LoadSave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel {
    private Game game;
    private Clouds cloud;
    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    private double x = 100;
    private double y = 0;
    private double vx = 0;
    private double vy = 0;
    private double g = 0.1;
    GamePanel(Game game){
        this.game = game;
        MouseInputs mouseInputs = new MouseInputs(this);
        KeyboardInputs keyboardInputs = new KeyboardInputs();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(new Color(96, 154, 247));
        this.setFocusable(true);
        addMouseListener(mouseInputs);
        addKeyListener(keyboardInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        move();
        draw(g);
    }

    public void setZero(){
        this.vx = 0;
        this.vy = 0;
    }

    public Game getGame() {
        return game;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void move(){
        if(x+100<=SCREEN_WIDTH && y+100<=SCREEN_HEIGHT) {
            updateObjectPos();
            updateObjectVel();
        }
    }
    public void updateObjectPos(){
        y += vy;
        x += vx;
    }
    public void updateObjectVel(){
        vy += g;
    }
    public void draw(Graphics g){
        game.render(g);
        g.setColor(Color.BLACK);
//        g.fillRect((int)x, (int)y, 100, 100);
    }
}
