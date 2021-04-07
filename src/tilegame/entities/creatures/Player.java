package tilegame.entities.creatures;


import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;
import tilegame.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    // Animations
    private final Animation animDown, animRight, animUp, animLeft;
    private final Animation animAttackDown, animAttackRight, animAttackUp, animAttackLeft;
    // Attack timer
    private long lastAttackTimer;
    private final long attackCooldown = 800;
    private long attackTimer = attackCooldown;
    // Inventory
    private Inventory inventory;


    private float xAttack = 0, yAttack = 0;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 32;
        bounds.y = 48;
        bounds.width = 32;
        bounds.height = 48;

        // Animations
        animDown = new Animation(150, Assets.playerDown);
        animRight = new Animation(150, Assets.playerRight);
        animUp = new Animation(150, Assets.playerUp);
        animLeft = new Animation(150, Assets.playerLeft);

        animAttackDown = new Animation(100, Assets.playerAttackDown);
        animAttackRight = new Animation(100, Assets.playerAttackRight);
        animAttackUp = new Animation(100, Assets.playerAttackUp);
        animAttackLeft = new Animation(100, Assets.playerAttackLeft);

        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {
        // Animations
        animDown.tick();
        animRight.tick();
        animUp.tick();
        animLeft.tick();

        animAttackDown.tick();
        animAttackRight.tick();
        animAttackUp.tick();
        animAttackLeft.tick();

        // Movement
        getInput();
        // Checking attacks before movement, if player is attacking he should stay still
        checkAttacks();
        move();
        handler.getGameCamera().centerOnEntity(this);
        // Inventory
        inventory.tick();

    }

    private void checkAttacks(){

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown) {
            // Player stanting still while attacking
            xMove = 0;
            yMove = 0;
            return;
        }

        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
            xAttack = 0;
            yAttack = 1;
        }else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            xAttack = 0;
            yAttack = -1;
        }else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            xAttack = -1;
            yAttack = 0;
        }else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            xAttack = 1;
            yAttack = 0;
        }else{
            return;
        }

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
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

        inventory.render(g);

        // Test code to check player boundaries
        
        // g.setColor(Color.blue);
        // g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
            //  (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
            //  bounds.width, bounds.height);
    }

    @Override
    public void die() {
        System.out.println("You lose");
    }

    private BufferedImage getCurrentAnimationFrame(){

        if(attackTimer < attackCooldown & yAttack < 0){
            return animAttackDown.getCurrentFrame();
        }else if (attackTimer < attackCooldown & yAttack > 0){
            return animAttackUp.getCurrentFrame();
        }else if (attackTimer < attackCooldown & xAttack < 0){
            return animAttackLeft.getCurrentFrame();
        }else if (attackTimer < attackCooldown & xAttack > 0){
            return animAttackRight.getCurrentFrame();
        } else if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else {
            return animDown.getCurrentFrame();
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
