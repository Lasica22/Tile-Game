package tilegame.entities.statics;

import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.tiles.Tile;

import java.awt.*;

public class Bush extends StaticEntity {

    public Bush(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bush, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {

    }
}
