public class SortApp{
   public static void main(String[] args){
      SortingEnchantment S= new SortingEnchantment();
      ElementalGem g1= new ElementalGem("water" , 9, 2, 3);
      ElementalGem g2= new ElementalGem("air" , 8, 3, 3);
      ElementalGem g3= new ElementalGem("fire" , 7, 5, 3);
      ElementalGem g4= new ElementalGem("earth" , 7, 6, 3);
      ElementalGem g5= new ElementalGem("earth" , 7, 2, 3);
      ElementalGem g6= new ElementalGem("air" , 6, 7, 3);
      ElementalGem g7= new ElementalGem("fire" , 9, 9, 3);
      ElementalGem g8= new ElementalGem("water" , 9, 4, 3);
      ElementalGem g9= new ElementalGem("fire" , 5, 8, 3);
      ElementalGem g10= new ElementalGem("air" , 9, 1, 3);
      ElementalGem g11= new ElementalGem("water" , 9, 2, 3);
      ElementalGem g12= new ElementalGem("air" , 5, 3, 3);
      ElementalGem g13= new ElementalGem("fire" , 3, 5, 3);
      ElementalGem g14= new ElementalGem("earth" , 4, 6, 3);
      ElementalGem g15= new ElementalGem("earth" , 4, 2, 3);
      ElementalGem g16= new ElementalGem("air" , 4, 7, 3);
      ElementalGem g17= new ElementalGem("fire" , 4, 9, 3);
      ElementalGem g18= new ElementalGem("water" , 9, 4, 3);
      ElementalGem g19= new ElementalGem("fire" , 5, 8, 3);
      ElementalGem g20= new ElementalGem("air" , 9, 1, 3);

      
      ElementalGem[] EG = {g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20};
      S.sortGems(EG);
      int i=1;
      for(ElementalGem a: EG) {
         System.out.println("" + i + ": " + a.toString());
         i++;
      }

   }
}