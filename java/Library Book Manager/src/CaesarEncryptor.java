public class CaesarEncryptor implements Encryptable {
      private int key;
      public CaesarEncryptor(long i){
            long sum=0;
            while(i>0){
                 sum+= i%10;
                 i= i/10;
            }
            key= (int)(sum%10);
      }
      @Override
      public String encrypt(String input) {
             String output="";
             for(int i=0; i<input.length(); i++){
                output += ""+ ((char)(input.charAt(i) + key));
             }
             return output;
      }
      @Override
      public String decrypt(String input){
             String output="";
             for(int i=0; i<input.length(); i++){
                output += "" + ((char)(input.charAt(i) - key));
             }
             return output;
      }


}