package Main;

import javax.swing.*;
import java.awt.*;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManage;

public class GamePanel extends JPanel implements Runnable{
    // screen setting
    final int originalTitleSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = originalTitleSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels
    //world setting
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;
//    public final int worldWidth = tileSize * maxWorldCol;
//    public final int worldHeight = tileSize * maxWorldRow;
    //FPS
    int FPS = 60;
    TileManage tileM = new TileManage(this);
    KeyHandler keyH = new KeyHandler(this);

    Sound sound =new Sound();
    Sound music=new Sound();
    Sound se=new Sound();

    Thread gameThread;
    public collisionChecker cChecker = new collisionChecker(this);
    public  AssetSetter aSetter =new AssetSetter(this);
    public UI ui=new UI(this);

    public Player player = new Player(this,keyH);
    //set player's default position
   public SuperObject obj[]=new SuperObject[30];
   public Entity npc[]=new Entity[30];


   //Game state
    public  int gameState;
    public  final int titleState=0;
    public final int playState=1;
    public final int pauseState=2;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
//        playMusic(0);
        gameState=titleState;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){
        double drawInterval = 1000000000/(double)FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta --;
                drawCount ++;
            }
            if(timer >= 1000000000){

                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        if(gameState==playState){
            //player
            player.update();
            //npc
            for(int i=0;i<npc.length;i++){
                if(npc[i]!=null){
                    npc[i].update();
                }
            }

        }
        if(gameState==pauseState){
            // do not thing
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //debug
        long drawStart=0;
        if(keyH.checkDrawTime==true) {
            drawStart = System.nanoTime();
        }
        //title screen;
        if(gameState ==titleState){
            ui.draw(g2);

        }
        //others
        else{
            //tile
            tileM.draw(g2);

            //object
            for(int i=0;i< obj.length;i++){
                if(obj[i]!=null){
                    obj[i].draw(g2,this);
                }
            }
            //npc
            for(int i=0;i< npc.length;i++){
                if(npc[i]!=null){
                    npc[i].draw(g2);
                }
            }
            //player
            player.draw(g2);
            //UI
            ui.draw(g2);
        }

        //debug
        if(keyH.checkDrawTime==true) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time : " + passed);
        }
        g2.dispose();
    }
    public void playMusic(int i){
       music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
