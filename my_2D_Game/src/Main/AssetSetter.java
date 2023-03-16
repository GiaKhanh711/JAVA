package Main;

import entity.NPC_Ghost;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Shose;

public class AssetSetter {
    GamePanel gp;
    public  AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        gp.obj[0]=new OBJ_Key(gp);
        gp.obj[0].worldX=77*gp.tileSize;
        gp.obj[0].worldY=23*gp.tileSize;

        gp.obj[1]=new OBJ_Key(gp);
        gp.obj[1].worldX=42*gp.tileSize;
        gp.obj[1].worldY=68*gp.tileSize;

        gp.obj[2]=new OBJ_Key(gp);
        gp.obj[2].worldX=24*gp.tileSize;
        gp.obj[2].worldY=79*gp.tileSize;

        gp.obj[3]=new OBJ_Key(gp);
        gp.obj[3].worldX=46*gp.tileSize;
        gp.obj[3].worldY=76*gp.tileSize;

        gp.obj[4]=new OBJ_Key(gp);
        gp.obj[4].worldX=51*gp.tileSize;
        gp.obj[4].worldY=63*gp.tileSize;

        gp.obj[5]=new OBJ_Key(gp);
        gp.obj[5].worldX=35*gp.tileSize;
        gp.obj[5].worldY=22*gp.tileSize;
        gp.obj[6]=new OBJ_Key(gp);
        gp.obj[6].worldX=34*gp.tileSize;
        gp.obj[6].worldY=78*gp.tileSize;
        gp.obj[7]=new OBJ_Key(gp);
        gp.obj[7].worldX=61*gp.tileSize;
        gp.obj[7].worldY=77*gp.tileSize;
        gp.obj[8]=new OBJ_Key(gp);
        gp.obj[8].worldX=78*gp.tileSize;
        gp.obj[8].worldY=62*gp.tileSize;
        gp.obj[9]=new OBJ_Key(gp);
        gp.obj[9].worldX=58*gp.tileSize;
        gp.obj[9].worldY=44*gp.tileSize;

        gp.obj[10]=new OBJ_Door(gp);
        gp.obj[10].worldX=25*gp.tileSize;
        gp.obj[10].worldY=25*gp.tileSize;

        gp.obj[11]=new OBJ_Chest(gp);
        gp.obj[11].worldX=24*gp.tileSize;
        gp.obj[11].worldY=22*gp.tileSize;

        gp.obj[12]=new OBJ_Shose(gp);
        gp.obj[12].worldX=60*gp.tileSize;
        gp.obj[12].worldY=50*gp.tileSize;

    }
    public  void setNPC(){
        gp.npc[0]=new NPC_Ghost(gp);
        gp.npc[0].worldX=31*gp.tileSize;
        gp.npc[0].worldY=50*gp.tileSize;

        gp.npc[1]=new NPC_Ghost(gp);
        gp.npc[1].worldX=49*gp.tileSize;
        gp.npc[1].worldY=63*gp.tileSize;

        gp.npc[2]=new NPC_Ghost(gp);
        gp.npc[2].worldX=54*gp.tileSize;
        gp.npc[2].worldY=53*gp.tileSize;

        gp.npc[3]=new NPC_Ghost(gp);
        gp.npc[3].worldX=69*gp.tileSize;
        gp.npc[3].worldY=37*gp.tileSize;

        gp.npc[4]=new NPC_Ghost(gp);
        gp.npc[4].worldX=61*gp.tileSize;
        gp.npc[4].worldY=25*gp.tileSize;

        gp.npc[5]=new NPC_Ghost(gp);
        gp.npc[5].worldX=41*gp.tileSize;
        gp.npc[5].worldY=31*gp.tileSize;

        gp.npc[6]=new NPC_Ghost(gp);
        gp.npc[6].worldX=22*gp.tileSize;
        gp.npc[6].worldY=51*gp.tileSize;

        gp.npc[7]=new NPC_Ghost(gp);
        gp.npc[7].worldX=35*gp.tileSize;
        gp.npc[7].worldY=63*gp.tileSize;

        gp.npc[8]=new NPC_Ghost(gp);
        gp.npc[8].worldX=69*gp.tileSize;
        gp.npc[8].worldY=77*gp.tileSize;

        gp.npc[9]=new NPC_Ghost(gp);
        gp.npc[9].worldX=49*gp.tileSize;
        gp.npc[9].worldY=71*gp.tileSize;

        gp.npc[10]=new NPC_Ghost(gp);
        gp.npc[10].worldX=30*gp.tileSize;
        gp.npc[10].worldY=23*gp.tileSize;

        gp.npc[11]=new NPC_Ghost(gp);
        gp.npc[11].worldX=38*gp.tileSize;
        gp.npc[11].worldY=41*gp.tileSize;

    }

}
