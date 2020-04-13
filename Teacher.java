public class Teacher{
   private String lastName;
   private String firstName;

   public Teacher(String ln, String fn){
      this.lastName = ln;
      this.firstName = fn;
   }

   //Getters
   public String getLastName(){
      return lastName;
   }

   public String getFirstName(){
      return firstName;
   }


   //Setters
   public void setLast(String inLast){
      lastName = inLast;
   }

   public void setFirst(String inFirst){
      firstName = inFirst;
   }
}
