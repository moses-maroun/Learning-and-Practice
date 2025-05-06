public class Student{
      private String name;
      private int ID, sum;
      private int grade1, grade2, grade3, average;
      public Student(String n, int id, int g1, int g2, int g3){
             sum=0;
             name=n;
             ID=id;
             grade1=g1;
             grade2=g2;
             grade3=g3;
             average = (g1+g2+g3)/3;
      }
      public String getName(){
             return name;
      }
      public int getID(){
            return ID;
      }
      public int getGrade1(){
            return grade1;
      }
      public int getGrade2(){
            return grade2;
      }
      public int getGrade3(){
            return grade3;
      }
      public int getAverage(){
            return average;
      }
      public String toString() {
           return (name + ", " + ID + ", " + grade1 + ", " + grade2 + ", " + grade3);
      }


}