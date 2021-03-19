package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 16, height = 16;
    private static final int playerWidth = 16, playerHeight = 24;

    public static BufferedImage player, dirt, grass, stone;
    public static BufferedImage[] player_down, player_right, player_up, player_left;

    public static void init (){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Assets.png"));

        player = sheet.crop (0,0, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0 ,width, height);

        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Player.png"));

        player_down = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_left = new BufferedImage[4];

        player_down[0] = playerSheet.crop(0,0,playerWidth,playerHeight);
        player_down[1] = playerSheet.crop(playerWidth,0,playerWidth,playerHeight);
        player_down[2] = playerSheet.crop(playerWidth * 2,0,playerWidth,playerHeight);
        player_down[3] = playerSheet.crop(playerWidth * 3,0,playerWidth,playerHeight);

        player_right[0] = playerSheet.crop(0,playerHeight,playerWidth,playerHeight);
        player_right[1] = playerSheet.crop(playerWidth,playerHeight,playerWidth,playerHeight);
        player_right[2] = playerSheet.crop(playerWidth * 2,playerHeight,playerWidth,playerHeight);
        player_right[3] = playerSheet.crop(playerWidth * 3,playerHeight,playerWidth,playerHeight);

        player_up[0] = playerSheet.crop(0,playerHeight * 2,playerWidth,playerHeight);
        player_up[1] = playerSheet.crop(playerWidth,playerHeight * 2,playerWidth,playerHeight);
        player_up[2] = playerSheet.crop(playerWidth * 2,playerHeight * 2,playerWidth,playerHeight);
        player_up[3] = playerSheet.crop(playerWidth * 3,playerHeight * 2,playerWidth,playerHeight);
        player_left[0] = playerSheet.crop(0,playerHeight * 3,playerWidth,playerHeight);

        player_left[1] = playerSheet.crop(playerWidth,playerHeight * 3,playerWidth,playerHeight);
        player_left[2] = playerSheet.crop(playerWidth * 2,playerHeight * 3,playerWidth,playerHeight);
        player_left[3] = playerSheet.crop(playerWidth * 3,playerHeight * 3,playerWidth,playerHeight);
    }
}
