import java.util.*;
import java.io.*;
public class FarmApp{
   public static void main(String[] args) throws IOException {
      Scanner scan= new Scanner(System.in);
      FileWriter fw= new FileWriter(new File("Map.txt"));
      PrintWriter pw= new PrintWriter(fw);
      Crop[][] crp1={{new Crop("food"), new Crop("food"), new Crop("feed"),new Crop("food")},
                     {new Crop("feed"), new Crop("food"), new Crop("food"), new Crop("food")},
                     {new Crop("food"), new Crop("food"), new Crop("food"), new Crop("feed")}};
      Field fld1= new Field(crp1);
      Crop[][] crp2={{new Crop("feed"), new Crop("feed"), new Crop("feed"),new Crop("food")},
                     {new Crop("food"), new Crop("food"), new Crop("feed"), new Crop("feed")},
                     {new Crop("feed"), new Crop("feed"), new Crop("food"), new Crop("feed")}};
      Field fld2= new Field(crp2);
      Farm frm= new Farm(fld1, fld2);
      
      int o=0;
      do{
        System.out.print("\n1. Plant Crop \n2. Boost Farm \n3. Boost field \n4. Harvest Farm "+
                           "\n5. Harvest field " + " \n6. Search for type \n7. Exit  \nEnter: ");
        o= scan.nextInt();
        if(o>=7){
          break;
        }
        else if(o==1){
           int k=0;
           System.out.print("Choose field 1 or 2: ");
           k=scan.nextInt();
           if(k==1) {
             System.out.print("\nEnter coordinate seperated by space (exp: x y): ");
             int x=scan.nextInt();
             int y=scan.nextInt();
             System.out.print("\nEnter the type: ");
             String t=scan.next();
             fld1.plantCrops(x, y, t);
           }
           else if(k==2) {
             System.out.print("\nEnter coordinate seperated by space (exp: x y): ");
             int x=scan.nextInt();
             int y=scan.nextInt();
             System.out.print("\nEnter the type: ");
             String t=scan.next();
             fld2.plantCrops(x, y, t);
           }
           

        }
        else if(o==2){
           System.out.print("\nBy how much do you want to boost(enter an integer): ");
           int b=scan.nextInt();
           frm.simulateCropGrowthAcrossFields(b);
           
        }
        else if(o==3){
           System.out.print("\nChoose field 1 or 2: ");
           int k=scan.nextInt();
           System.out.print("\nBy how much you want to boost(enter an integer): ");
           int b=scan.nextInt();
           if(k==1){
             fld1.simulateCropsGrowth(b);
           }
           else if(k==2){
             fld2.simulateCropsGrowth(b);
           }
           
        }
        else if(o==4){
           frm.harvestCropsFromAllFields();
           
        }
        else if(o==5){
           System.out.print("\nChoose field 1 or 2: ");
           int k=scan.nextInt();
           if(k==1){
             fld1.harvestCrops();
           }
           else if(k==2){
             fld2.harvestCrops();
           }
           
        }
        else if(o==6){
           System.out.print("\nSearch: ");
           String s=scan.next();
           frm.searchForCropTypeAcrossFields(s);
           
        }
      }while(o<7);
      pw.println(frm.displayFarm());
      scan.close();
      pw.close();
      fw.close();
   }
}