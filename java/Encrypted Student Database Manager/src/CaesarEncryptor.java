public class CaesarEncryptor implements Encryptable{
       private int id, key;
       
       public CaesarEncryptor(int I) {
              id=I;
              key=0;
              int sum=0;
              while(I>0){
                 sum+=I%10;
                 I=I/10;
              }
              key= sum%10;
       }
       @Override
       public String encrypt(String input) {
             String output="";
             
             for(int i=0; i<input.length(); i++) {
                  output+= ""+ ((char)(input.charAt(i) + key));
             }
             return output;
       }
       @Override
       public String decrypt(String input){
              String output="";
              for(int i=0; i<input.length(); i++) {
                 output+= ""+ ((char)(input.charAt(i) - key));
              }
              return output;
       }



}