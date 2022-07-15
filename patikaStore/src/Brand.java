import java.util.Comparator;
import java.util.TreeSet;

public class Brand {

    private int id;
    private String name;
    private static TreeSet<Brand> listOfBrand=new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    static {
        createBrands();
    }

    public Brand(int id,String name){
        this.id=id;
        this.name=name;
    }
    public static void createBrands(){
        listOfBrand.add(new Brand(1,"Samsung"));
        listOfBrand.add(new Brand(2,"Lenovo"));
        listOfBrand.add(new Brand(3,"Apple"));
        listOfBrand.add(new Brand(4,"Huawei"));
        listOfBrand.add(new Brand(5,"Casper"));
        listOfBrand.add(new Brand(6,"Asus"));
        listOfBrand.add(new Brand(7,"HP"));
        listOfBrand.add(new Brand(8,"Xiaomi"));
        listOfBrand.add(new Brand(9,"Monster"));
    }

    public static void printListOfBrands() {
        System.out.println("Markalar");

        for (Brand brandItem : listOfBrand) {
            System.out.println(brandItem.id + " " + brandItem.getName());
        }

        System.out.println("*-*-*-*-*-*-*-*-*");
    }

    public static Brand getBrand(int id){
        for(Brand brandItem: listOfBrand){

            if(id==brandItem.getId()){

                return brandItem;
            }
        }
        return null;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
