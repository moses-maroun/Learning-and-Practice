public class ElementalGem{
      private int rarity, size, clarity;
      private String affinity;
      
      public ElementalGem(String a, int r, int s, int c) {
            if(a.toLowerCase().equals("fire")||a.toLowerCase().equals("water")||a.toLowerCase().equals("earth")||a.toLowerCase().equals("air")){
              affinity = a.toUpperCase();
            }
            else {
                System.out.println("Affinity not found please set it manually and enter the right type!!");
            }
            rarity=r;
            size=s;
            clarity=c;
      }
      public void setAffinity(String a){
            if(a.toLowerCase().equals("fire")||a.toLowerCase().equals("water")||a.toLowerCase().equals("earth")||a.toLowerCase().equals("air")){
              affinity = a.toUpperCase();
            }
            else {
                System.out.println("Affinity not found please set it again and enter the right type!!");
            }
      }
      public void setRarity(int r){
            rarity=r;
      }
      public void setSize(int s){
            size=s;
      }
      public void setClarity(int c){
            clarity=c;
      }
      public String getAffinity(){
            return affinity;
      }
      public int getRarity(){
            return rarity;
      }
      public int getSize(){
            return size;
      }
      public int getClarity(){
            return clarity;
      }
      public String toString(){
            return ("Affinity: " + affinity + "\tRarity: " + rarity);
      }






}