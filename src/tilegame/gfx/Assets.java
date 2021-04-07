package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 16, height = 16;
    private static final int playerWidth = 64, playerHeight = 64;

    public static BufferedImage player, dirt, grass, stone, bush, stick;
    public static BufferedImage[] playerDown, playerRight, playerUp, playerLeft;
    public static BufferedImage[] playerAttackDown, playerAttackRight, playerAttackUp, playerAttackLeft;
    public static BufferedImage[] btn_start;
    public static BufferedImage inventoryScreen;

    public static void init (){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Assets.png"));

        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(0, height,width * 2,height);
        btn_start[1] = sheet.crop(width * 2, height, width * 2, height);

        player = sheet.crop (0,0, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0 ,width, height);
        bush = sheet.crop(width * 4, 0,width, height);
        stick = sheet.crop(width * 5, 0, width, height);

        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/PlayerWalking.png"));

        playerUp = new BufferedImage[8];
        playerLeft = new BufferedImage[playerUp.length];
        playerDown = new BufferedImage[playerUp.length];
        playerRight = new BufferedImage[playerUp.length];

        for(int i = 0; i < playerUp.length; i++){
            playerUp[i] = playerSheet.crop(playerWidth * (i + 1), 0, playerWidth, playerHeight);
            playerLeft[i] = playerSheet.crop(playerWidth * (i + 1), playerHeight, playerWidth, playerHeight);
            playerDown[i] = playerSheet.crop(playerWidth * (i + 1), playerHeight * 2, playerWidth, playerHeight);
            playerRight[i] = playerSheet.crop(playerWidth * (i+ 1), playerHeight * 3, playerWidth, playerHeight);
        }

        SpriteSheet attackSheet = new SpriteSheet(ImageLoader.loadImage("/textures/PlayerAttack.png"));

        playerAttackUp = new BufferedImage[6];
        playerAttackLeft = new BufferedImage[playerAttackUp.length];
        playerAttackDown = new BufferedImage[playerAttackUp.length];
        playerAttackRight = new BufferedImage[playerAttackUp.length];


        for(int i = 0; i < playerAttackUp.length; i++){
            playerAttackUp[i] = attackSheet.crop(playerWidth * i, 0, playerWidth, playerHeight);
            playerAttackLeft[i] = attackSheet.crop(playerWidth * i, playerHeight, playerWidth, playerHeight);
            playerAttackDown[i] = attackSheet.crop(playerWidth * i, playerHeight * 2, playerWidth, playerHeight);
            playerAttackRight[i] = attackSheet.crop(playerWidth * i, playerHeight * 3, playerWidth, playerHeight);
        }

        inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
    }
}
