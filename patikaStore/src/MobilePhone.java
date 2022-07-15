import java.util.*;

public class MobilePhone extends Product{

    private static int phoneId=1;

    private String name;
    private int battery;
    private String color;

    private static ArrayList<MobilePhone> phoneList=new ArrayList<>();

    public MobilePhone(){

    }

    public MobilePhone(String name, double price, int discountRate, int currentPrice, Brand brand, double screenSize, int ram, int memory,
                       int battery, String color) {
        super(phoneId,name, price, discountRate, currentPrice, brand, screenSize, ram, memory);
        this.battery=battery;
        this.color=color;
        phoneId++;

    }

    @Override
    public void menu() {
        System.out.println("1- Add new mobile phone\n" +
                "2- Show mobile phone list\n" +
                "3- Delete mobile phone\n" +
                "4- Sort by mobile phone from Id\n" +
                "5- Sort by mobile phone from Brand");

        System.out.print("Please select a number from menu : ");
        int selectedNumber = scanner.nextInt();


        if(selectedNumber==1){
            addItem();
        }
        else if(selectedNumber==2){
            getProducts();
        }
        else if(selectedNumber==3){
            deleteItem();
        }
        else if(selectedNumber == 4){
            getProducts();
        }
        else if(selectedNumber==5){
            brandFilter();
        }
    }

    @Override
    public void addItem() {
        System.out.println("Product Name : ");
        String name=scanner.nextLine();
        scanner.nextLine();

        System.out.println("Current Price : ");
        double currentPrice= scanner.nextDouble();

        System.out.println("Discount Rate : ");
        int discountRate= scanner.nextInt();

        System.out.println("Product stock : ");
        int stock= scanner.nextInt();

        System.out.print("Product RAM : ");
        int ram= scanner.nextInt();

        System.out.print("Screen Size : ");
        double screenSize= scanner.nextDouble();

        System.out.print("Product Memory :");
        int memory= scanner.nextInt();

        System.out.print("Battery : ");
        int battery= scanner.nextInt();

        System.out.print("Product Color : ");
        String color= scanner.nextLine();

        scanner.nextLine();

        Brand.printListOfBrands();

        System.out.print("Please choose Brand : ");
        Brand selectedBrand=Brand.getBrand(scanner.nextInt());

        MobilePhone phone =new MobilePhone(name,currentPrice,discountRate,stock,selectedBrand,screenSize,ram,memory,battery,color);
        phoneList.add(phone);

        System.out.println("Added mobile phone Id :"+ phone.getId());
    }

    public void getProducts() {
        print(null);
    }

    public void print(ArrayList<MobilePhone> phoneList){

        if(phoneList==null) {
            phoneList=this.phoneList;

        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name              | Current Price   | Brand         | Stock      | Discount Rate    | RAM  | Screen Size     | Memory   | Battery  | Color |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone phoneItem : phoneList){
            System.out.printf("| %-2s | %-25s | %-15s | %-13s | %-10s | %-16s | %-4s | %-15s | %-8s | %-8s | %-5s | \n",
                    phoneItem.getId(),phoneItem.getName(),phoneItem.getCurrentPrice(),phoneItem.getBrand().getName(),phoneItem.getStock(),
                    phoneItem.getDiscountRate(),phoneItem.getRam(),phoneItem.getScreenSize(),phoneItem.getMemory(),phoneItem.getBattery(),phoneItem.getColor());
        }
    }

    @Override
    public void deleteItem(){
        getProducts();
        System.out.print("Please enter Id for delete product : ");
        int enteredProductId = scanner.nextInt();

        phoneList.remove(enteredProductId-1);

        System.out.println("Updated mobile phone list");
        getProducts();
    }

    public void brandFilter(){

        System.out.print("Please enter to brand name :");
        String brandNamefilter= scanner.nextLine();

        ArrayList<MobilePhone> filterPhone=new ArrayList<>();

        for (MobilePhone n:phoneList){
            if(brandNamefilter.equals(n.getBrand().getName())){
                filterPhone.add(n);
            }
        }
        print(filterPhone);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getProductIdId() {
        return phoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
