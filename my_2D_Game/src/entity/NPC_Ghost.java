package entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Ghost extends Entity{
    public NPC_Ghost(GamePanel gp){
        super(gp);
        direction ="down";
        speed=3;
        getImage();
    }
    public void getImage(){

        up1=setup("/Res/npc/tile000");
        up2=setup("/Res/npc/tile001");
        up3=setup("/Res/npc/tile002");
        up4=setup("/Res/npc/tile003");

        right1=setup("/Res/npc/tile000");
        right2=setup("/Res/npc/tile001");
        right3=setup("/Res/npc/tile002");
        right4=setup("/Res/npc/tile003");


        down1=setup("/Res/npc/tile000");
        down2=setup("/Res/npc/tile001");
        down3=setup("/Res/npc/tile002");
        down4=setup("/Res/npc/tile003");

        left1=setup("/Res/npc/tile000");
        left2=setup("/Res/npc/tile001");
        left3=setup("/Res/npc/tile002");
        left4=setup("/Res/npc/tile003");
    }
  public void setAction(){
        actionLockCounter++;
        if(actionLockCounter ==120) {


            Random random = new Random();
            int i = random.nextInt(100) + 1;//pick up a number from 1 to 100
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter =0;
        }
  }

}
