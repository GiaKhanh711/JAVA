package Main;

import object.OBJ_Heart;
import object.OBJ_Key;
import object.SuperObject;

import java.awt.*;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font font,fontend;
    BufferedImage keyImage;
    BufferedImage heart_full,heart_half,heart_blank;

    public  boolean messageOn =false;
    public String message="";
    int messageCounter=0;
    public boolean gameFinished= false;
    double playTime;
    DecimalFormat dFomat=new DecimalFormat("#0.00");
    public int commandNum=0;
    public UI(GamePanel gp){
        this.gp=gp;
        font =new Font("Comic Sans MS", Font.BOLD,30);
        fontend =new Font("Comic Sans MS", Font.BOLD,80);
        OBJ_Key key=new OBJ_Key(gp);
        keyImage=key.image;
        //creat hub obj
        SuperObject heart=new OBJ_Heart(gp);
        heart_full=heart.image;
        heart_half=heart.image2;
        heart_blank=heart.image3;

    }
    public  void showMessage(String text){
        message =text;
        messageOn=true;
    }
    public void draw(Graphics2D g2) {
        this.g2=g2;

          g2.setFont(font);
          g2.setColor(Color.white);
          String text;
          //title state
        if(gp.gameState==gp.titleState){
            drawTitleScreen();
        }
        //play state
        if(gp.gameState==gp.playState) {

            if (gameFinished == true) {




                int textLength;
                int x;
                int y;
                text = "You Won !!!";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth / 2 - textLength / 2;
                y = gp.screenHeight / 2 - (gp.tileSize * 3);
                g2.drawString(text, x, y);

                text = "You Time is :" + dFomat.format(playTime) + " S !!!";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth / 2 - textLength / 2;
                y = gp.screenHeight / 2 + (gp.tileSize * 4);
                g2.drawString(text, x, y);

                g2.setFont(fontend);
                g2.setColor(Color.pink);
                text = "Congratulstions  !!!";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();


                x = gp.screenWidth / 2 - textLength / 2;
                y = gp.screenHeight / 2 + (gp.tileSize * 3);
                g2.drawString(text, x, y);

                gp.gameThread = null;

            } else {
                this.g2 = g2;
                g2.setFont(font);
                g2.setColor(Color.white);
                g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
                g2.drawString("x " + gp.player.hasKey + "/10", 75, 50);

                g2.drawString("X:" + +gp.player.worldX / gp.tileSize + " Y:" + gp.player.worldY / gp.tileSize, gp.tileSize*10, 100);
                //time
                playTime += (double) 1 / 60;
                g2.drawString("Time : " + dFomat.format(playTime) + " S", gp.tileSize * 10, 50);

                drawPlayerLife();
                //mesage
                if (messageOn == true) {
                    g2.setFont(g2.getFont().deriveFont(20F));
                    g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;
                    }
                }

            }

        }
        //game pause
        if(gp.gameState==gp.pauseState){

            drawPauseScreen();
        }

    }
    public  void drawPlayerLife(){
        gp.player.life=5;
        int x=gp.tileSize/2;
        int y=gp.tileSize*2;
        int i=0;
        //draw full
        while (i<gp.player.maxLife/2){
            g2.drawImage(heart_blank,x,y,null);
            i++;
            x+=gp.tileSize;
        }
       x=gp.tileSize/2;
       y=gp.tileSize*2;
       i=0;
        //draw current life
        while (i<gp.player.life){
            g2.drawImage(heart_half,x,y,null);
            i++;
           if(i<gp.player.life){
               g2.drawImage(heart_full,x,y,null);
           }
           i++;
           x+=gp.tileSize;
        }
    }
    public  void drawTitleScreen(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);

        //title name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        String text="2D ADVENTURE";
        int x=getXforCenteredText(text);
        int y=gp.tileSize*3;
        //Shadow
        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);
        //maincolor
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        // main player
        x=gp.screenWidth/2-(gp.tileSize*2)/2;
        y+=gp.tileSize*2;
        g2.drawImage(gp.player.down1,x,y,gp.tileSize*2,gp.tileSize*2,null);
        //menu
        gp.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
         text="New Game";
        x=getXforCenteredText(text);
        y+=gp.tileSize*3;
        g2.drawString(text,x,y);
        if(commandNum==0){
            g2.drawString(">",x-gp.tileSize,y);
        }

        text="Load Game";
        x=getXforCenteredText(text);
        y+=gp.tileSize*1.3;
        g2.drawString(text,x,y);
        if(commandNum==1){
            g2.drawString(">",x-gp.tileSize,y);
        }

        text="Quit Game";
        x=getXforCenteredText(text);
        y+=gp.tileSize*1.3;
        g2.drawString(text,x,y);
        if(commandNum==2){
            g2.drawString(">",x-gp.tileSize,y);
        }

    }



    public void drawPauseScreen(){
        g2.setFont(fontend);
        String text="PAUSE";
        int x=getXforCenteredText(text);

        int y=gp.screenHeight/2;
        g2.drawString(text,x,y);
    }
    public int getXforCenteredText(String text){
        int lenght =(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x=gp.screenWidth/2-lenght/2;
        return x;
    }

}
