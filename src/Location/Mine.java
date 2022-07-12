package Location;

import monsters.Snake;
import InventoryGame.Player;

public class Mine extends BattleLocation{

    //is one type of battale location
    public Mine(Player newPlayer) {
        super(6, newPlayer, "Mine", new Snake(), 5);
    }
}
