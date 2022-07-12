import java.util.Comparator;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        TreeSet<Book> books=new TreeSet<Book>();

        Book book1=new Book("Pal Sokağı Çocukları",150,"ferenc molner","1906");
        Book book2=new Book("Ateşten Gömlek",250,"Halide Edip Adıvar","1922");
        Book book3=new Book("Kaşağı",125,"Ömer Seyfettin","1942");
        Book book4=new Book("Makiler",180,"Sunay Akın","2012");
        Book book5=new Book("Ince Memed",450,"Yaşar Kemal","1970");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        System.out.println("İsme göre sıralama : ");
        for(Book book:books){

            System.out.println("Kitap Adı : "+book.getName()+
                    ",\t Sayfa Sayısı : "+book.getPage()+
                    ",\t Yazarın Adı : "+book.getAuthor()+
                    ",\t Yayın Tarihi : "+ book.getReleaseDate());
        }


        TreeSet<Book> books2=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage() - o2.getPage();
            }
        });
        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);
        System.out.println("----------------------------------");
        System.out.println("Sayfa sayısına göre sıralama :");
        for (Book book:books2) {
            System.out.println("Kitap adı : " + book.getName() +
                    ",\t Sayfa Sayısı : " + book.getPage() +
                    ",\t Yazarın İsmi : " + book.getAuthor() +
                    ",\t Yayın Tarihi : " + book.getReleaseDate());
        }
    }
}
