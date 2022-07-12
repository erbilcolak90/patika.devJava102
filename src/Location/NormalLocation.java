package Location;
import InventoryGame.Player;

public abstract class NormalLocation extends Location{
    public NormalLocation(int newId,Player newPlayer, String newName) {
        super(newId,newPlayer, newName);
    }
    @Override
    public boolean onLocation() {
        return true;
    }

}
