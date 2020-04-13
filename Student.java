public class Student{
   private String lastName;
   private String firstName;
   private int grade;
   private int classroom;
   private int bus;
   private float gpa;

   public Student(String ln, String fn, int grade, int room, int bus, int gpa){
      this.lastName = ln;
      this.firstName = fn;
      this.grade = grade;
      this.classroom = room;
      this.bus = bus;
      this.gpa = gpa;
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

}


