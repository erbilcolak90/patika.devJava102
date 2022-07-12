package Location;

import monsters.Vampire;
import InventoryGame.Player;

public class Forest extends BattleLocation{

    //is one type of battle location
    public Forest(Player player){

        super(5, player, "Forest", new Vampire(), 3);
    }
}