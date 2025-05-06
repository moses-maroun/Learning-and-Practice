public class Field{
   private Crop[][] field;
   
   public Field(Crop[][] f){
      field = f;
   }
   
   public void plantCrops(int i, int j, String t){
      if(field[i][j]==null){
         field[i][j]= new Crop(t);
      }
      else{
        System.out.println("There is already a Crop here!!");
      }
   }
   public void simulateCropsGrowth(int s) {
      for(int i=0; i<field.length; i++){
         for(int j=0; j<field[i].length; j++){
            if(field[i][j]!=null){
               field[i][j].simulateCropGrowth(s);
            }
         }
      }
   }
   public void harvestCrops(){
      for(int i=0; i<field.length; i++){
         for(int j=0; j<field[i].length; j++){
            if(field[i][j]!=null && field[i][j].isRipeForHarvest()){
               
               field[i][j] = null;
               
            }
         }
      }
   }
   public String searchForCropType(String t){
      String c="";
      for(int i=0; i<field.length; i++){
         for(int j=0; j<field[i].length; j++){
            if(field[i][j]!=null){
               if(field[i][j].getType().equals(t.toUpperCase())){
                 c+= ("(" + i + " , " + j + "); ");
               }
            }
         }
      }
      return c;
   }
   public String display(){
      String c="";
      for(int i=0; i<field.length; i++){
         c+=""+i+":\t";
         for(int j=0; j<field[i].length; j++){
            if(field[i][j]!=null){
              c+=("|"+field[i][j].toString()+"|");
            }
            else if(field[i][j]==null){
              c+=("| NULL |");
            }
            
         }
         c+="\n";
      }
      return c;
   }

}