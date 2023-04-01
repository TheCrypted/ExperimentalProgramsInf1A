package main;

import Entity.TestChar;
import Utils.ChessSpace;

import java.awt.*;

public class Game implements Runnable{
    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private TestChar testChar;
    private ChessSpace chessSpace;
    private Thread gameThread;
    private final int FPS = 120;
    private final int UPS = 200;
    Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
        startGame();

    }
    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update() {
        testChar.updateTestChar();
    }

    public void render(Graphics g){
        if (chessSpace.isBoxClicked()) {
            chessSpace.render(g);
        }
        testChar.render(g);

    }

    private void initClasses() {
        testChar = new TestChar(270, -20);
        chessSpace = new ChessSpace();
    }

    public ChessSpace getChessSpace() {
        return chessSpace;
    }

    @Override
    public void run() {
        double frameTime = 1000000000.0/FPS;
        double updateTime = 1000000000.0/UPS;
        long previousTime = System.nanoTime();
        int frames = 0;
        int updates = 0;
        long lastTime = System.currentTimeMillis();
        double deltaU = 0;
        double deltaF = 0;

        while (true) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime)/updateTime;
            deltaF += (currentTime - previousTime)/frameTime;
            previousTime = currentTime;
            if(deltaU >= 1){
                update();
                updates++;
                deltaU --;
            }
            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF --;
            }
            if(System.currentTimeMillis() - lastTime >= 100){
                lastTime = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }

        }


    }

    public TestChar getTestChar() {
        return testChar;
    }
}
