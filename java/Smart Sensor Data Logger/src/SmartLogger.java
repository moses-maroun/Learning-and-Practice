import java.util.*;
import java.io.*;
import java.text.*;
public class SmartLogger{
      public static void main(String[] args) throws IOException {
         Scanner scan1= new Scanner(new File("../sensor_log.txt"));
         Scanner scan2= new Scanner(System.in);
         ArrayList<SensorReading> arr= new ArrayList<>();
         
         int o=0;
         int count1=0;
         double avrg1=0;
         int count2=0;
         double avrg2=0;
         int count3=0;
         double avrg3=0;
         while(scan1.hasNextLine()){
            String line= scan1.nextLine();
            if (line.isEmpty()) continue;
            Scanner sc= new Scanner(line);
            sc.useDelimiter(", ");
         
            String t=sc.next();
            double v= sc.nextDouble();
            String time= sc.next();
         
            SensorReading SR= new SensorReading(t , v, time);
            arr.add(SR);
         }
         count1= Count(arr, "Temperature");
         avrg1= Average(arr, "Temperature");
         count2= Count(arr, "Humidity");
         avrg2= Average(arr, "Humidity");
         count3= Count(arr, "Pressure");
         avrg3= Average(arr, "Pressure");  
         System.out.println("Sensor: " + "Temperature - " + count1 + " readings, Average= " + avrg1 
                             + "\nSensor: " + "Humidity - " + count2 + " readings, Average= " + avrg2
                             + "\nSensor: " + "Pressure - " + count3 + " readings, Average= " + avrg3);
         

         
         do{

                      
           System.out.print("Menu:\n1. Add a new sensor reading\n2. View all readings by type\n3. View highest and lowest values by type"
                            +"\n4. Exit \nEnter: ");
           o=scan2.nextInt();
           if(o>=4){
             break;
           }
           else if(o==1){
               FileWriter fw= new FileWriter(new File("../sensor_log.txt"), true);
               PrintWriter pw= new PrintWriter(fw);
               Scanner scan3= new Scanner(System.in);
               System.out.print("Enter the infos in the following format(type value): ");
               Date now = new Date();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String tm = sdf.format(now);
               String l= scan3.nextLine();
               Scanner S=new Scanner(l);
               S.useDelimiter(" ");
               String type= S.next();
               double val= S.nextDouble();
               SensorReading SR1= new SensorReading(type , val, tm);
               arr.add(SR1);
               pw.println(SR1.getType() + ", " + SR1.getValue() + ", " + SR1.getTime());
               
               pw.close();
               fw.close();
               
               count1= Count(arr, "Temperature");
               avrg1= Average(arr, "Temperature");
               count2= Count(arr, "Humidity");
               avrg2= Average(arr, "Humidity");
               count3= Count(arr, "Pressure");
               avrg3= Average(arr, "Pressure");  
               System.out.println("Sensor: " + "Temperature - " + count1 + " readings, Average= " + avrg1 
                             + "\nSensor: " + "Humidity - " + count2 + " readings, Average= " + avrg2
                             + "\nSensor: " + "Pressure - " + count3 + " readings, Average= " + avrg3);

           }
           else if(o==2){
              System.out.println("Enter Type: ");
              String srch= scan2.next();
              String rslt="";
              for(SensorReading a: arr){
                 if(a.getType().equalsIgnoreCase(srch)){
                   rslt += ("\n"+ a.getType() + ", " + a.getValue() + ", " + a.getTime());
                 }
              }
              System.out.println(rslt);
              
           }
           else if(o==3){
              double min1=getMin(arr, "Temperature");
              double max1=getMax(arr, "Temperature");
              double min2=getMin(arr, "Humidity");
              double max2=getMax(arr, "Humidity");
              double min3=getMin(arr, "Pressure");
              double max3=getMax(arr, "Pressure");
              System.out.println("Temperature: \n\tMax: " + max1 + "\n\tMin: " + min1
                  +"\nHumidity: \n\tMax: " + max2 + "\n\tMin: " + min2
                  +"\nPressure: \n\tMax: " + max3 + "\n\tMin: " + min3);

              
           }
         }while(o<4);
         
       }
       public static int Count(ArrayList<SensorReading> a, String t){
           int count=0;
           for(SensorReading s: a){
              if(s.getType().equalsIgnoreCase(t)){
                count+=1;
              }
           }
           return count;
       }
       public static double Average(ArrayList<SensorReading> a, String t){
           double avrg=0;
           int count=0;
           for(SensorReading s: a){
              if(s.getType().equalsIgnoreCase(t)){
                avrg+=s.getValue();
              }
           }
           if(count!=0){
             return avrg/count;
           }
           else{
             return 0.0;
           }
             
       }
       public static double getMax(ArrayList<SensorReading> a, String t){
             double max=Double.NEGATIVE_INFINITY;
             for(SensorReading s: a){
               if(s.getType().equalsIgnoreCase(t) && s.getValue()>max){
                 max=s.getValue();
               }
             }
             if(max==Double.NEGATIVE_INFINITY){
               return Double.NaN;
             }
             return max;
       }
       public static double getMin(ArrayList<SensorReading> a, String t){
             double min=Double.POSITIVE_INFINITY;
             for(SensorReading s: a){
               if(s.getType().equalsIgnoreCase(t) && s.getValue()<min){
                 min=s.getValue();
               }
             }
             if(min==Double.POSITIVE_INFINITY){
               return Double.NaN;
             }
             return min;
       }



}