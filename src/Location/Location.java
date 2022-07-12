package Location;

import InventoryGame.Player;

import java.util.Scanner;

public abstract class Location {
    private int id;
    private Player player;
    private String name;
    protected Scanner scanner = new Scanner(System.in);

    public Location(int newId,Player newPlayer,String newName) {

        this.id = newId;
        this.player = newPlayer;
        this.name = newName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public abstract boolean onLocation();
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }

}
