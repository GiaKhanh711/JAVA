package entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey=0;


    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

        this.keyH = keyH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gp.tileSize*75;
        worldY = gp.tileSize*79;
        speed = 3;
        direction = "up";

        //player status
        maxLife =6;
        life=maxLife;
    }
    public void getPlayerImage(){

        up1=setup("/Res/player/tile002");
        up2=setup("/Res/player/tile006");
        right1=setup("/Res/player/tile003");
        right2=setup("/Res/player/tile007");
        down1=setup("/Res/player/tile000");
        down2=setup("/Res/player/tile004");
        left1=setup("/Res/player/tile001");
        left2=setup("/Res/player/tile005");
    }

    public void update(){
      if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed) {
                direction = "up";
            }
            else if(keyH.downPressed){
                direction = "down";
            }
            else if(keyH.leftPressed ){
                direction = "left";
            }
            else if(keyH.rightPressed){
                direction = "right";
            }
            //check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            //check npc collision
          int npcIndex =gp.cChecker.checkEntity(this,gp.npc);
          interactNPC(npcIndex);
            //check obj collision
           int objIndex=gp.cChecker.checkObject(this,true);

           pickUpObject(objIndex);
            //if collision is false, player can move
            if(collisionOn == false){
                switch (direction){
                    case "up": worldY -= speed;break;
                    case "down": worldY += speed;break;
                    case "left": worldX -= speed;break;
                    case "right": worldX += speed;break;
                }
            }
            spriteCounter ++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;

              }
                spriteCounter = 0;
            }
        }

    }
    public  void pickUpObject(int i){
        if(i !=999){
           String objectName=gp.obj[i].name;

           switch (objectName){
               case "Key" :
                   gp.playSE(1);
                   hasKey++;
                   gp.obj[i]=null;
                 gp.ui.showMessage("You got a key !!!");
                   break;
               case "Door" :
                   if(hasKey==10) {
                       gp.playSE(3);
                       gp.obj[i] = null;
                       hasKey=0;
                       gp.ui.showMessage("The door opened !!!");
                   }
                   else {
                       gp.ui.showMessage(" You need 10 keys !!!");
                   }

                   break;
               case "Shose":
                   gp.playSE(2);
                   speed+=1;
                   gp.obj[i]=null;
                   gp.ui.showMessage("Speed up !!!");
                   break;
               case "Chest":
                   gp.ui.gameFinished=true;
                   gp.stopMusic();
                   gp.playSE(4);
                   break;
           }
        }

    }
    public void interactNPC(int i){
        if(i!=999){
            System.out.println("you are hitting npc");
        }
    }

    public void draw(Graphics g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
               break;

            case "up" :
                if(spriteNum==1){
                    image=up1;
                }
                if(spriteNum==2){
                    image=up2;
                }

               break;
            case "left" :
                if(spriteNum==1){
                    image=left1;
                }
                if(spriteNum==2){
                    image=left2;
                }

              break;
            case "right" :
                if(spriteNum==1){
                    image=right1;
                }
                if(spriteNum==2){
                    image=right2;
                }

              break;




        }


        g2.drawImage(image,screenX,screenY,null);
    }
}