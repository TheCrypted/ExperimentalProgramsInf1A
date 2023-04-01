package MainRun;

import Entities.Clouds;
import Entities.Connect4;

import java.awt.*;

public class Game implements Runnable {
    private GamePanel gamePanel;
    private GameFrame gameFrame;
    private Thread gameThread;
    private static final int FPS = 120;
    private static final int UPS = 200;
    private Clouds cloud;
    private Connect4 connect4;
    Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameFrame = new GameFrame(gamePanel);
        startGame();
    }



    public boolean isRunnable() {
        boolean[][] runnableCheck = getConnect4().getConnected();
        for(int i = 0; i < runnableCheck[0].length; i++){
            if(!runnableCheck[0][i] && !connect4.isWinCheckAlpha()){
                return true;
            }
        }
        return false;
    }
    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    private void initClasses(){
        cloud = new Clouds();
        connect4 = new Connect4();
    }

    public Connect4 getConnect4() {
        return connect4;
    }

    public Clouds getCloud() {
        return cloud;
    }

    public void render(Graphics g) {
        cloud.draw(g);
        connect4.draw(g);
    }
    public void update(){
        cloud.updateCloudPos(cloud.getPosArray());
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

        while(isRunnable()){
            long currentTime = System.nanoTime();
            deltaF += (currentTime - previousTime)/frameTime;
            deltaU += (currentTime - previousTime)/updateTime;
            previousTime = currentTime;
            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            if(System.currentTimeMillis() - lastTime >= 1000){
                lastTime = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
