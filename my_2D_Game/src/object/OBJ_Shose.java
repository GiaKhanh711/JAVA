package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Shose extends SuperObject {
    GamePanel gp;
    public OBJ_Shose(GamePanel gp) {
        this.gp=gp;
        name = "Shose";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Res/object/shose.png"));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);

        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}
