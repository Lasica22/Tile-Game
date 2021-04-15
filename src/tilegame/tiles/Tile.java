package tilegame.tiles;

import tilegame.Handler;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    // Handler

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new Tile(Assets.grass, 0, false);
    public static Tile dirtTile = new Tile(Assets.dirt, 1, false);
    public static Tile rockTile = new Tile(Assets.stone, 2, true);
    public static Tile waterBlank = new Tile(Assets.waterBlank, 3, true);
    public static Tile grassWaterN = new Tile(Assets.grassWaterN, 4, false);
    public static Tile grassWaterNE = new Tile(Assets.grassWaterNE, 5, false);
    public static Tile grassWaterE = new Tile(Assets.grassWaterE, 6, false);
    public static Tile grassWaterSE = new Tile(Assets.grassWaterSE, 7, false);
    public static Tile grassWaterS = new Tile(Assets.grassWaterS, 8, false);
    public static Tile grassWaterSW = new Tile(Assets.grassWaterSW, 9, false);
    public static Tile grassWaterW = new Tile(Assets.grassWaterW, 10, false);
    public static Tile grassWaterNW = new Tile(Assets.grassWaterNW, 11, false);
    public static Tile waterGrassNW = new Tile(Assets.waterGrassNW, 12, false);
    public static Tile waterGrassNE = new Tile(Assets.waterGrassNE, 13, false);
    public static Tile waterGrassSW = new Tile(Assets.waterGrassSW, 14, false);
    public static Tile waterGrassSE = new Tile(Assets.waterGrassSE, 15, false);


    // CLASS

    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;
    protected boolean solid;

    protected Handler handler;

    public Tile(BufferedImage texture, int id, boolean solid){
        this.texture = texture;
        this.id = id;
        this.solid = solid;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid(){
        return solid;
    }

    public int getId() {
        return id;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
