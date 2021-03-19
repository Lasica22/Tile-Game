package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 16, height = 16;
    private static final int playerWidth = 16, playerHeight = 24;

    public static BufferedImage player, dirt, grass, stone, bush;
    public static BufferedImage[] playerDown, playerRight, playerUp, playerLeft;
    public static BufferedImage[] playerAttackDown, playerAttackRight, playerAttackUp, playerAttackLeft;
    public static BufferedImage[] btn_start;

    public static void init (){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Assets.png"));

        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(0, height,width * 2,height);
        btn_start[1] = sheet.crop(width * 2, height, width * 2, height);

        player = sheet.crop (0,0, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0 ,width, height);
        bush = sheet.crop(width * 4, 0,width,height);

        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Player.png"));

        playerDown = new BufferedImage[4];
        playerRight = new BufferedImage[4];
        playerUp = new BufferedImage[4];
        playerLeft = new BufferedImage[4];

        playerDown[0] = playerSheet.crop(0,0,playerWidth,playerHeight);
        playerDown[1] = playerSheet.crop(playerWidth,0,playerWidth,playerHeight);
        playerDown[2] = playerSheet.crop(playerWidth * 2,0,playerWidth,playerHeight);
        playerDown[3] = playerSheet.crop(playerWidth * 3,0,playerWidth,playerHeight);

        playerRight[0] = playerSheet.crop(0,playerHeight,playerWidth,playerHeight);
        playerRight[1] = playerSheet.crop(playerWidth,playerHeight,playerWidth,playerHeight);
        playerRight[2] = playerSheet.crop(playerWidth * 2,playerHeight,playerWidth,playerHeight);
        playerRight[3] = playerSheet.crop(playerWidth * 3,playerHeight,playerWidth,playerHeight);

        playerUp[0] = playerSheet.crop(0,playerHeight * 2,playerWidth,playerHeight);
        playerUp[1] = playerSheet.crop(playerWidth,playerHeight * 2,playerWidth,playerHeight);
        playerUp[2] = playerSheet.crop(playerWidth * 2,playerHeight * 2,playerWidth,playerHeight);
        playerUp[3] = playerSheet.crop(playerWidth * 3,playerHeight * 2,playerWidth,playerHeight);

        playerLeft[0] = playerSheet.crop(0,playerHeight * 3,playerWidth,playerHeight);
        playerLeft[1] = playerSheet.crop(playerWidth,playerHeight * 3,playerWidth,playerHeight);
        playerLeft[2] = playerSheet.crop(playerWidth * 2,playerHeight * 3,playerWidth,playerHeight);
        playerLeft[3] = playerSheet.crop(playerWidth * 3,playerHeight * 3,playerWidth,playerHeight);

        /*playerAttackDown = new BufferedImage[4];
        playerAttackRight = new BufferedImage[4];
        playerAttackUp = new BufferedImage[4];
        playerAttackLeft = new BufferedImage[4];

        playerAttackDown[0] = playerSheet.crop(0,playerHeight * 4,playerWidth,playerHeight);
        playerAttackDown[1] = playerSheet.crop(playerWidth,playerHeight * 4,playerWidth,playerHeight);
        playerAttackDown[2] = playerSheet.crop(playerWidth * 2,playerHeight * 4,playerWidth,playerHeight);
        playerAttackDown[3] = playerSheet.crop(playerWidth * 3,playerHeight * 4,playerWidth,playerHeight);

        playerAttackRight[0] = playerSheet.crop(0,playerHeight * 5,playerWidth,playerHeight);
        playerAttackRight[1] = playerSheet.crop(playerWidth,playerHeight * 5,playerWidth,playerHeight);
        playerAttackRight[2] = playerSheet.crop(playerWidth * 2,playerHeight * 5,playerWidth,playerHeight);
        playerAttackRight[3] = playerSheet.crop(playerWidth * 3,playerHeight * 5,playerWidth,playerHeight);

        playerAttackUp[0] = playerSheet.crop(0,playerHeight * 5,playerWidth,playerHeight);
        playerAttackUp[1] = playerSheet.crop(playerWidth,playerHeight * 5,playerWidth,playerHeight);
        playerAttackUp[2] = playerSheet.crop(playerWidth * 2,playerHeight * 5,playerWidth,playerHeight);
        playerAttackUp[3] = playerSheet.crop(playerWidth * 3,playerHeight * 5,playerWidth,playerHeight);

        playerAttackLeft[0] = playerSheet.crop(0,playerHeight * 5,playerWidth,playerHeight);
        playerAttackLeft[1] = playerSheet.crop(playerWidth,playerHeight * 5,playerWidth,playerHeight);
        playerAttackLeft[2] = playerSheet.crop(playerWidth * 2,playerHeight * 5,playerWidth,playerHeight);
        playerAttackLeft[3] = playerSheet.crop(playerWidth * 3,playerHeight * 5,playerWidth,playerHeight);*/
    }
}
