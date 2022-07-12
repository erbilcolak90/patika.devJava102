package InventoryGame;

import Location.Cave;
import Location.Forest;
import Location.Location;
import Location.Mine;
import Location.River;
import Location.SafeHouse;
import Location.Store;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    // the game starts by the start function
    public void start(){

        System.out.println("******Welcome to Adventure Game******");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        System.out.println("Welcome <"+ player.getName()+">");
        System.out.println("Pick the ID of character to start the game:");
        //selecting Game Character
        player.selectChar();
        //showing the player info
        player.printPlayerInfo();

        //Selecting location
        Location[] location ={new SafeHouse(player), new Store(player), new Cave(player), new River(player), new Forest(player), new Mine(player)};

        //while exit is false the game will continue
        boolean exit = false;
        while(!exit){

            //before selecting any location by user the initial location is set to null
            Location selectedLocation = null;
            System.out.println("***************************");
            System.out.println("Locations:");
            for(Location loc:location){

                System.out.println("ID:"+loc.getId()+" Location: "+loc.getName());
            }
            System.out.println("0 for Exit");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("<If you want to try your chance for earning money or getting Armor or getting Weapon, you are recommended to go to Mine location.>");
            System.out.print("Please select your location : ");
            int pickedId = scanner.nextInt();
            switch(pickedId){

                case 0:
                    exit = true;
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println("You are leaving the game...");
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
                    break;

                case 1:
                    selectedLocation = new SafeHouse(player);
                    break;

                case 2:
                    selectedLocation = new Store(player);
                    break;

                case 3:

                    if(player.getInventory().isFood()){

                        System.out.println("Finished your task in this location and you can't go there again!!!");
                        break;
                    }
                    selectedLocation = new Cave(player);
                    break;

                case 4:

                    if(player.getInventory().isFirewood()){

                        System.out.println("Finished your task in this location and you can't go there again!!!");
                        break;
                    }
                    selectedLocation = new River(player);
                    break;

                case 5:

                    if(player.getInventory().isWater()){

                        System.out.println("Finished your task in this location and you can't go there again!!!");
                        break;
                    }
                    selectedLocation = new Forest(player);
                    break;

                case 6:

                    selectedLocation = new Mine(player);
                    break;


                default:
                    selectedLocation = new SafeHouse(player);
                    break;
            }

            if(selectedLocation != null){

                if(!selectedLocation.onLocation()){

                    if(player.getHealth()== 0){

                        System.out.println("***GAME OVER***");
                        break;
                    }
                    else{

                        break;
                    }
                }

            }
        }
    }
}