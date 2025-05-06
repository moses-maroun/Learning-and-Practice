public class Crop{
   private String type="";
   private int stage;
   
   public Crop(String t) {
      if(t.toUpperCase().equals("FOOD") || t.toUpperCase().equals("FEED")){
         type = t;
      }
      else{
         System.out.println("Wrong type set it again correctly!!");
      }
      stage= 0;
   }

   public void setType(String t) {
      if(t.toUpperCase().equals("FOOD") || t.toUpperCase().equals("FEED")){
         type = t;
      }
      else{
         System.out.println("Wrong type set it again correctly!!");
      }
   }
   public String getType(){
      return type;
   }
   public int getStage(){
      return stage;
   }
   
   public void simulateCropGrowth(int i){
      stage+=i;
   }
   public boolean isRipeForHarvest(){
      boolean r=false;
      if(type.equalsIgnoreCase("FOOD") && stage>=5){
        r = true;
      }
      else if(type.equalsIgnoreCase("FEED") && stage>=3){
        r = true;
      }
      return r;
   }
   public String toString(){
      return (""+type+","+stage);
   }

}