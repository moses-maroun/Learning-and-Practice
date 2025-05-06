import java.util.*;
public class Farm{
   ArrayList<Field> farm= new ArrayList<>();
   
   public Farm(Field ... arr) {
      for(Field a: arr){
         farm.add(a);
      }
   }
   
   public void simulateCropGrowthAcrossFields(int s){
      for(Field a: farm){
         a.simulateCropsGrowth(s);
      }
   }
   public void harvestCropsFromAllFields(){
      for(Field a: farm){
         a.harvestCrops();
      }
   }
   public String searchForCropTypeAcrossFields(String t){
      String c="";
      int i=1;
      for(Field a: farm){
         c+=""+i+": ";
         c+=(a.searchForCropType(t) + "\n");
         i++;
      }
      return c;
   }
   public String displayFarm(){
      String c="";
      for(Field a: farm){
         c+= (""+ a.display() + "\n\n");
      }
      return c;
   }

}