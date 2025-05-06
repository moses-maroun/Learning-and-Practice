public class SortingEnchantment{
       public ElementalGem[] sortGems(ElementalGem[] e) {
             for(int i=0; i<e.length; i++){
                int k=i;
                for(int j=i+1; j<e.length; j++){
                   if(e[j].getRarity()<e[k].getRarity()){
                     k=j;
                   }
                }
             ElementalGem temp = e[k];
             e[k]=e[i];
             e[i]=temp;
             }
             for(int i=1; i<e.length; i++){
                ElementalGem temp = e[i];
                int j=i-1;
                
                while(j>=0 && e[j].getAffinity().compareTo(temp.getAffinity())>0 && e[j].getRarity()==temp.getRarity()){
                   e[j+1]=e[j];
                   j--;
                   
                }
                e[j+1]=temp;
             }
             return e;
       }

}