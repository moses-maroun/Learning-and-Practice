public class SensorReading{
    private String sensorType;
    private double value;
    private String timestamp;
    public SensorReading(String type, double v, String time){
          if(!isValid(type)){
            throw new IllegalArgumentException("Invalid sensor type: " + type);
          }
          sensorType=type;
          value= v;
          timestamp= time;
    }
    private static boolean isValid(String t){
        return (t.equalsIgnoreCase("Temperature") || t.equalsIgnoreCase("Humidity") || t.equalsIgnoreCase("Pressure")); 
    }
    public String getType(){
        return sensorType;
    }
    public String getTime(){
        return timestamp;
    }
    public double getValue(){
        return value;
    }
    public void setTime(String t){
        timestamp=t;
    }
    public void setValue(double v){
        value=v;
    }
    public void setType(String t){
        sensorType=t;
    }


}