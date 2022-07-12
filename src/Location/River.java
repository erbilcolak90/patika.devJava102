package Location;


import monsters.Bear;
import InventoryGame.Player;

public class River extends BattleLocation {

    //is one type of battle location
    public River(Player player) {

        super(4, player, "River", new Bear(), 3);

    }
}
