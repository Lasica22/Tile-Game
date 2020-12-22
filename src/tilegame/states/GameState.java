package tilegame.states;

import tilegame.Game;
import tilegame.entities.creatures.Player;
import tilegame.gfx.Assets;
import tilegame.tiles.Tile;
import tilegame.world.World;

import java.awt.*;

public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Game game){
        super(game);
        player = new Player(game,100, 100    );
        world = new World(game, "res/worlds/world1.txt");

    }

    @Override
    public void tick() {
        world.tick();
        player.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
