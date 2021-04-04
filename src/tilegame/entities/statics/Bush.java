package tilegame.entities.statics;

import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.items.Item;
import tilegame.tiles.Tile;

import java.awt.*;

public class Bush extends StaticEntity {

    public Bush(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
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
        handler.getWorld().getItemManager().addItem(Item.stickItem.createNew((int) x, (int) y));
    }
}