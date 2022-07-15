import java.util.ArrayList;

public class Notebook extends Product{

    private static int noteBookId=1;

    private String name;
    private static ArrayList<Notebook> notebookList=new ArrayList<>();


    public Notebook(String name, double price, int discountRate, int stock, Brand brand, double screenSize, int ram, int memory) {

        super(noteBookId,name, price, discountRate, stock, brand, screenSize, ram, memory);
        noteBookId++;

    }


    public Notebook(){

    }
    @Override
    public void menu() {

        System.out.println("1- Add Notebook\n" +
                "2- Show Notebook list\n" +
                "3- Delete Notebook\n" +
                "4- Sort by Notebook from id \n" +
                "5- Sort by Notebook from brand");

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
        System.out.print("Product Name : ");
        String name= scanner.nextLine();
        scanner.nextLine();

        System.out.print("Product Price : ");
        double price= scanner.nextDouble();

        System.out.print("Discount Rate : ");
        int discountRate= scanner.nextInt();

        System.out.print("Product Stock : ");
        int stock= scanner.nextInt();

        System.out.print("Product RAM : ");
        int ram= scanner.nextInt();

        System.out.print("Screen Size : ");
        double screenSize= scanner.nextDouble();

        System.out.print("Product Memory :");
        int memory= scanner.nextInt();

        Brand.printListOfBrands();

        System.out.print("Please choose a brand : ");
        Brand brand=Brand.getBrand(scanner.nextInt());

        Notebook notebook=new Notebook(name,price,discountRate,stock,brand,screenSize,ram,memory);
        notebookList.add(notebook);

        System.out.println("Added notebook Id :"+notebook.getId());
    }

    @Override
    public void getProducts() {
        print(null);
    }

    public void print(ArrayList<Notebook> notebookList){
        if(notebookList==null){
            notebookList=this.notebookList;
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name              | Current Price   | Brand         | Stock      | Discount Rate    | RAM    | Screen Size      | Memory    |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook notebookItem: notebookList){
            System.out.printf("| %-2s | %-25s | %-15s | %-13s | %-10s | %-16s | %-6s | %-16s | %-9s | \n",
                    notebookItem.getId(),notebookItem.getName(),notebookItem.getCurrentPrice(),notebookItem.getBrand().getName(),notebookItem.getStock(),
                    notebookItem.getDiscountRate(),notebookItem.getRam(),notebookItem.getScreenSize(),notebookItem.getMemory());
        }
    }

    @Override
    public void deleteItem(){
        getProducts();
        System.out.print("Please enter Id for delete product : ");
        int enteredProductId = scanner.nextInt();

        notebookList.remove(enteredProductId-1);
        System.out.println("Updated notebook list ");
        getProducts();
    }

    private void brandFilter() {


        System.out.print("Please enter to brand name :");
        String brandNamefilter= scanner.nextLine();

        ArrayList<Notebook> filterNotebook=new ArrayList<>();

        for (Notebook n:notebookList){

            if(brandNamefilter.equals(n.getBrand().getName())){
                filterNotebook.add(n);
            }
        }
        print(filterNotebook);
    }

    public static int getnId() {
        return noteBookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
