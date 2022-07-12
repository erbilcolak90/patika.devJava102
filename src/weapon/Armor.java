package weapon;

public class Armor {

    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int newId, String newName, int newBlock, int newPrice){

        this.id = newId;
        this.name = newName;
        this.block =newBlock;
        this.price = newPrice;
    }

    public static Armor[] armors (){

        Armor[] armors = new Armor[3];
        armors[0] = new Armor(1, "light", 1, 15);
        armors[1] = new Armor(2, "middle", 3, 25);
        armors[2] = new Armor(3, "heavy", 5, 40);

        return armors;
    }

    public static Armor getArmorObjById(int id){

        for(Armor a : armors()){

            if(a.getId() == id){

                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
