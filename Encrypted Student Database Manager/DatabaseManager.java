import java.util.*;
import java.io.*;

public class DatabaseManager{
      public static void main(String[] args) throws IOException {
            Scanner scan = new Scanner(new File("encrypted_students.txt"));
            Scanner sc= new Scanner(new File("students.txt"));
            FileWriter fw= new FileWriter(new File("encrypted_students.txt"));
            PrintWriter pw= new PrintWriter(fw);
            ArrayList<Student> stu= new ArrayList<>();
            System.out.println("Loading student data from file...\n");
            while(sc.hasNextLine()){
                String l=sc.nextLine();
                Scanner sc1= new Scanner(l);
                sc1.useDelimiter(", ");
                Student s= new Student(sc1.next(), sc1.nextInt(), sc1.nextInt(), sc1.nextInt(), sc1.nextInt());
                stu.add(s);
            }
            System.out.println("Encrypting grades and saving to encrypted_students.txt...\n");
            for(Student a: stu) {
               CaesarEncryptor ce= new CaesarEncryptor(a.getID());
               String g1=ce.encrypt(""+ a.getGrade1());
               String g2=ce.encrypt(""+ a.getGrade2());
               String g3=ce.encrypt(""+ a.getGrade3());
               pw.println(""+ a.getName() + ", " + a.getID() + ", " + g1 + ", " + g2 + ", " + g3);
            }
            System.out.println("Sorting students by average grade...\n");
            for(int i=0; i<stu.size(); i++){
               int k=i;
               for(int j=i+1; j<stu.size(); j++){
                  if(stu.get(j).getAverage()>stu.get(k).getAverage()){
                    k=j;
                  }
               }
               Student max= stu.get(k);
               stu.set(k, stu.get(i));
               stu.set(i, max);
            }
            System.out.println("Top 3 Students: " + "\n1. " + stu.get(0).getName() + " - Average: " + stu.get(0).getAverage() + 
                                                   "\n2. " + stu.get(1).getName() + " - Average: " + stu.get(1).getAverage() +
                                                   "\n3. " + stu.get(2).getName() + " - Average: " + stu.get(2).getAverage() );
            for(int i=0; i<stu.size(); i++){
               int k=i;
               for(int j=i+1; j<stu.size(); j++){
                  if(stu.get(j).getID()<stu.get(k).getID()){
                    k=j;
                  }
               }
               Student temp= stu.get(k);
               stu.set(k, stu.get(i));
               stu.set(i, temp);
            }
            
            
            Scanner scan1 = new Scanner(System.in);
            
            System.out.println("Enter a student ID: ");
            int srch= scan1.nextInt();
            int max=stu.size();
            int min=0;
            int i=(stu.size()/2);
            boolean found= false;
            while(max>=min){
                 if(stu.get(i).getID()==srch) {
                   System.out.print("Student found! \n" + stu.get(i).toString());
                   found= true;
                   break;
                 }
                 else if(stu.get(i).getID()<srch) {
                      min=i+1;
                      i= (min + max)/2;
                 }
                 else if(stu.get(i).getID()>srch) {
                      max=i-1;
                      i= (min+max)/2;
                 }
            }
            if(!found){
              System.out.println("Student not found!!");
            }

            pw.close();
            fw.close();


      }

}