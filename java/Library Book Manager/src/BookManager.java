import java.util.*;
import java.io.*;
public class BookManager{
      public static void main(String[] args) throws IOException {
            Scanner scan= new Scanner(new File("../library.txt"));
            FileWriter fw= new FileWriter(new File("../encrypted_books.txt"));
            PrintWriter pw= new PrintWriter(fw);
            ArrayList<book> lib= new ArrayList<>();
            while(scan.hasNextLine()){
                 String l=scan.nextLine();
                 Scanner sc1= new Scanner(l);
                 sc1.useDelimiter(", ");
                 book b= new book(sc1.next(), sc1.next(), sc1.nextLong(), sc1.nextInt(), sc1.nextInt());
                 lib.add(b);
            }
            for(book a: lib) {
               CaesarEncryptor ce= new CaesarEncryptor(a.getISBN());
               pw.println(""+ a.getTitle() + ", " + a.getAuthor() + ", " + a.getISBN() + ", " + ce.encrypt(""+a.getPages()) + ", " + 
                                ce.encrypt(""+a.getYear()) );
            }
            for(int i=0; i<lib.size(); i++){
               int k=i;
               for(int j=i+1; j<lib.size(); j++) {
                  if(lib.get(j).getAge()>lib.get(k).getAge()){
                     k=j;
                  }
               }
               book max= lib.get(k);
               lib.set(k, lib.get(i));
               lib.set(i, max);
            }
             
            System.out.println("the Top 3 oldest books: " + "\n1. " + lib.get(0).getTitle() +
                                                    "\n2. " + lib.get(1).getTitle() +
                                                    "\n3. " + lib.get(2).getTitle() );
            for(int i=0; i<lib.size(); i++){
               int k=i;
               for(int j=i+1; j<lib.size(); j++) {
                  if(lib.get(j).getISBN()<lib.get(k).getISBN()){
                     k=j;
                  }
               }
               book temp= lib.get(k);
               lib.set(k, lib.get(i));
               lib.set(i, temp);
            }
            
            Scanner sc= new Scanner(System.in);
            System.out.print("Search for book, enter ISBN: ");
            long srch= sc.nextLong();
            int max=lib.size();
            int min=0;
            boolean found= false;
            int i=(max+min)/2;
            while(max>=min){
                 if(lib.get(i).getISBN()==srch){
                   System.out.println(lib.get(i).toString());
                   found = true;
                   break;
                 }
                 else if(lib.get(i).getISBN()<srch) {
                      min=i+1;
                      i= (max+min)/2;
                 }
                 else if(lib.get(i).getISBN()>srch) {
                      max= i-1;
                      i= (max+min)/2;
                 }
            }
            if(!found) {
              System.out.println("book not Found!!");
            }


            pw.close();
            fw.close();
      } 


}