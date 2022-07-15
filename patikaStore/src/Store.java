import java.util.*;

public class Store {
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("Patika Store Product Manager Panel");
            System.out.println(" 1 - Notebook\n" +
                    " 2 - Mobile Phone\n" +
                    " 3 - List Brand\n" +
                    " 4 - Exit");
            System.out.print("Please select a number from main menu : ");

            switch (scanner.nextInt()) {
                case 1:
                    Notebook notebook=new Notebook();
                    notebook.menu();
                    break;
                case 2:
                    MobilePhone mobilePhone=new MobilePhone();
                    mobilePhone.menu();
                    break;
                case 3:
                    Brand.printListOfBrands();
                    break;
                case 4:
                    System.out.println("You've lefting a store...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid value");
                    break;
            }
        }
    }
}
