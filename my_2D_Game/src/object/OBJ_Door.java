package object;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends SuperObject {
    GamePanel gp;
    public OBJ_Door(GamePanel gp){
        this.gp=gp;
        name ="Door";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Res/object/doorclose.png"));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        collision =true;
    }
}
