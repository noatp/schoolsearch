/*Group#19 
 * Toan Chau, Kattia Chang, Nick Teng, Syrsha Harvey
 */
public class Node{
   private String lastName;
   private String firstName;
   private int grade;
   private int classroom;
   private int bus;
   private float gpa;
   private String teacherLast;
   private String teacherFirst;

   public Node(String ln, String fn, int grade, int room, int bus, float gpa, String last, String first){
      this.lastName = ln;
      this.firstName = fn;
      this.grade = grade;
      this.classroom = room;
      this.bus = bus;
      this.gpa = gpa;
      this.teacherLast = last;
      this.teacherFirst = first;
   }

   //Getters
   public String getLastName(){
      return lastName;
   }

   public String getFirstName(){
      return firstName;
   }

   public int getGrade(){
      return grade;
   }

   public int getRoom(){
      return classroom;
   }

   public int getBus(){
      return bus;
   }

   public float getGpa(){
      return gpa;
   }

   public String getTeachLast(){
      return teacherLast;
   }

   public String getTeachFirst(){
      return teacherFirst;
   }

   //Setters
   public void setLast(String inLast){
      lastName = inLast;
   }

   public void setFirst(String inFirst){
      firstName = inFirst;
   }

   public void setGrade(int inGrade){
      grade = inGrade;
   }

   public void setClassroom(int inClass){
      classroom = inClass;
   }

   public void setBus(int inBus){
      bus = inBus;
   }

   public void setGpa(float inGpa){
      gpa = inGpa;
   }

   public void setTeachLast(String inLast){
      teacherLast = inLast;
   }

   public void setTeachFirst(String inFirst){
      teacherFirst = inFirst;
   }

   public void printNode(){//for debug purposes
      System.out.println(lastName + " " + firstName + " " + grade + " " + 
            classroom + " " + bus + " " + gpa + " " + teacherLast + " " + 
            teacherFirst);
   }

}


