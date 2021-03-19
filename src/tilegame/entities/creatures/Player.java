package tilegame.entities.creatures;


import tilegame.Handler;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    // Animations
    private Animation animDown, animRight, animUp, animLeft;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 22;
        bounds.y = 22;
        bounds.width = 20;
        bounds.height = 42;

        // Animations
        animDown = new Animation(500, Assets.player_down);
        animRight = new Animation(500, Assets.player_right);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
    }

    @Override
    public void tick() {
        // Animations
        animDown.tick();
        animRight.tick();
        animUp.tick();
        animLeft.tick();

        // Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

      //  g.setColor(Color.blue);
      //   g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
      //          (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
      //          bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return  animUp.getCurrentFrame();
        }else{
            return animDown.getCurrentFrame();
        }

    }
}
