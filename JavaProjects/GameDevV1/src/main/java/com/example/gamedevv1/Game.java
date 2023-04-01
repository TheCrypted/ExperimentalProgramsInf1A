package com.example.gamedevv1;

import Entity.Player;
import Levels.LevelManager;

import java.awt.*;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS = 120;
    private final int UPS = 200;
    public static int spriteIndex = 0;
    public final static int TILE_DEF_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int GAME_WIDTH_TILES = 26;
    public final static int GAME_HEIGHT_TILES = 14;
    public final static int TILESIZE = (int)(TILE_DEF_SIZE*SCALE);
    public final static int GAME_HEIGHT = TILESIZE*GAME_HEIGHT_TILES;
    public final static int GAME_WIDTH = GAME_WIDTH_TILES*TILESIZE;
    private Player player;
    private LevelManager levelManager;
    public Game(){
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGame();
    }

    private void initClasses() {
        player = new Player(200, 200, (int)(64*SCALE), (int)(40*SCALE));
        levelManager = new LevelManager(this);
        player.loadlvlData(levelManager.getCurrentLevel().getLvlData());
    }

    private void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);

    }
    public void update(){
        player.update();
        levelManager.update();
    }

    public Player getPlayer() {
        return player;
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
//            if(System.nanoTime() - lastFrameTime >= frameTime){
//                lastFrameTime = System.nanoTime();
//                gamePanel.repaint();
//                frames++;
//                spriteIndex ++;
//            }
            if(System.currentTimeMillis() - lastTime >= 100){
                lastTime = System.currentTimeMillis();
//                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
            if(spriteIndex >= 80){
                spriteIndex = 0;
            }

        }
    }

    public void windowLostFocus() {
        player.resetDirBooleans();
    }
}
