package Location;

import weapon.Armor;
import weapon.Weapon;
import InventoryGame.Player;

/*
this calss is used for bying weapon and armor
**
*/
public class Store extends NormalLocation{

    public Store(Player player){
        super(2,player, "Store");
    }

    @Override
    public boolean onLocation(){

        //while exit is false the player will stay in store
        boolean exit =false;
        System.out.println(">>>>>>>>Welcome to store<<<<<<<<");
        while(!exit){

            System.out.println("1- Weapon");
            System.out.println("2- Armor");
            System.out.println("3- Exit");
            int choice = scanner.nextInt();

            while(choice<1 || choice> 3){

                System.out.println("Invalid value.Please enter your choice number :");
                choice = scanner.nextInt();
            }

            //selecting one option of the store menue
            switch(choice){

                case 1:
                    printWeapons();
                    buyWeapon();
                    showPleyerInfo();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    showPleyerInfo();
                    break;
                case 3:
                    System.out.println("See you again");
                    exit = true;
                    break;
            }

        }
        return true;
    }

    //showing the weapons in the store
    public void printWeapons(){

        System.out.println("*-*-*-*-*-* Weapons *-*-*-*-*-*-*");
        for(Weapon w : Weapon.weapons()){

            System.out.println("Id:"+w.getId()+"\t"+" Name:"+w.getName()+"\t"+" Damage:"+w.getDamage()+"\t"+" Price:"+w.getPrice());
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

    }

    //buying weapon from store
    public void buyWeapon(){

        System.out.print("Please pick the ID for weapon to buy: ");
        int selectedId = scanner.nextInt();

        while(selectedId<1 && selectedId>Weapon.weapons().length){

            System.out.println("Please choose the correct ID and try again!");
            selectedId = scanner.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjById(selectedId);
        if(selectedWeapon != null){

            //checking the balance of player if it has enough money to buy the product
            if(selectedWeapon.getPrice()> this.getPlayer().getMoney()){

                System.out.println("Sorry, there is not enought money in your balance!!!");
            }
            else{
                int balance = this.getPlayer().getMoney()- selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Order seccessfully done!");
                System.out.printf("You purchased one %s armor\n",selectedWeapon.getName());
                System.out.println("Your balance : "+this.getPlayer().getMoney());
            }
        }
    }


    // showing the armors that are in store
    public void printArmor(){

        System.out.println("*--*-*-*-*-*-*-*Armors*--*-*-*-*-*-*-*-*");
        for(Armor a : Armor.armors()){

            System.out.println("Id:"+a.getId()+"\t"+" Type: "+a.getName()+"\t"+" Block: "+a.getBlock()+"\t"+" Price: "+a.getPrice());
        }
        System.out.println("0: Exit");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }


    public void buyArmor(){

        System.out.println("Please choose the ID of your favorite armor to buy:");
        int selectedId = scanner.nextInt();
        while(selectedId<0 || selectedId>Armor.armors().length){

            System.out.println("Please choose the right Id and then try again");
            selectedId = scanner.nextInt();
        }

        if(selectedId != 0){

            Armor selectedArmor = Armor.getArmorObjById(selectedId);

            if(selectedArmor != null ){

                if(this.getPlayer().getMoney() - selectedArmor.getPrice()>= 0){
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your order successfully done!");
                    System.out.printf("You purchased one %s armor\n",selectedArmor.getName());
                    System.out.println("Your new balance is: "+this.getPlayer().getMoney());
                }
                else{

                    System.out.println("You can not buy "+selectedArmor.getName()+" because, there not enought money in your balance.");
                }

            }

        }
    }
    public void showPleyerInfo(){

        this.getPlayer().printPlayerInfo();
    }
}