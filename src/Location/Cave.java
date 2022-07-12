package Location;
import monsters.Zombie;
import InventoryGame.Player;

public class Cave extends BattleLocation{

    //is one type of battle location
    public Cave(Player newPlayer) {
        super(3 , newPlayer, "Cave", new Zombie(), 3);
    }
}
