/*Group#19 
 * Toan Pham, Kattia Chang, Nick Teng
 */

import java.util.*;
import java.io.*;

class schoolsearch {

    static boolean finishSearch = false;
    static ArrayList<Node> list = new ArrayList<>();
    static boolean fileFound = fileExists();
    static int [] arr = new int[7];


    public static void main(String[] args) throws IOException{
       if(!fileFound){
         System.out.println("Required file not found...exiting program");
       }
       else{
         fileToList(list);
         addTeacherToList(list);
         studentsPerGrade();
         
         while (!finishSearch && fileFound){
            System.out.print("Please input search instruction:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = reader.readLine();
            Scanner in = new Scanner(userInput);

            switch (in.next())
            {
                case "Student:":
                    parseInputForStudent(in);
                    break;
                case "S:":
                    parseInputForStudent(in);
                    break;

                case "Teacher:":
                    parseInputForTeacher(in);
                    break;
                case "T:":
                    parseInputForTeacher(in);
                    break;
                
                case "Bus:":
                    parseInputForBus(in);
                    break;
                case "B:":
                    parseInputForBus(in);
                    break;

                case "Grade:":
                    parseInputForGrade(in);
                    break;
                case "G:":
                    parseInputForGrade(in);
                    break;

                case "Average:":
                    parseInputForAverage(in);
                    break;
                case "A:":
                    parseInputForAverage(in);
                    break;

                case "Info":
                    getInfo();
                    break;
                case "I":
                    getInfo();
                    break;

                case "Analytics:":
                    parseInputForAnalytics(in);
                    break;
                case "An:":
                    parseInputForAnalytics(in);
                    break;

                case "Classroom:":
                    parseInputForClassroom(in);
                    break;
                case "C:":
                    parseInputForClassroom(in);
                    break;

                case "E":
                    parseInputForEnrollment(in);
                    break;
                case "Enrollment":
                    parseInputForEnrollment(in);
                    break;
       
                case "Q":
                    finishProgram();
                    break;
                case "Quit":
                    finishProgram();
                    break;

                default:
                    wrongInputFormat();
                    break;
            }
         }
       }
    }

    static void parseInputForStudent(Scanner in)
    {
        String lastName = "";
        String busOption;

        if (in.hasNext())
        {
            lastName = in.next();
        }
        else
        {
            wrongInputFormat();
            return;
        }

        if (in.hasNext()) // has bus input
        {
            busOption = in.next();

            if(busOption.equals("B")||busOption.equals("Bus"))
            {
                searchStudentBus(lastName);
            }
        }
        else
        {
            searchStudentNoBus(lastName); // no bus input
        }
    }

    static void searchStudentNoBus(String lastName)
    {
        int counter = 0;
        for (Node student : list)
        {
            if(student.getLastName().equals(lastName))
            {
                System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " Grade: " + student.getGrade() + " Classroom: "
                        + student.getRoom() + " Teacher: " + student.getTeachFirst() + " " + student.getTeachLast());
                counter++;
            }
        }
        if(counter == 0)
        {
            System.out.println("No students with this last name");
        }
    }

    static void searchStudentBus(String lastName)
    {
        int counter = 0;
        for (Node student : list)
        {
            if(student.getLastName().equals(lastName))
            {
                System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " Bus Route: " + student.getBus());
                counter++;
            }
        }
        if(counter == 0)
        {
            System.out.println("No students with this last name");
        }
    }

    static void parseInputForTeacher(Scanner in)
    {
        String lastName = "";

        if (in.hasNext())
        {
            lastName = in.next();
            searchTeacher(lastName);
        }
        else
        {
            wrongInputFormat();
            return;
        }
    }

    static void searchTeacher(String lastName)
    {
        int counter = 0;
        for (Node student : list)
        {
            if(student.getTeachLast().equals(lastName))
            {
                System.out.println("Student: " + student.getFirstName() + ", " + student.getLastName());
                counter++;
            }
        }
        if(counter == 0)
        {
            System.out.println("No teacher with this last name");
        }
    }

    static void parseInputForBus(Scanner in)
    {
        int busNumber;
        
        if (in.hasNextInt()) // has bus input
        {
            busNumber = in.nextInt();
            searchBus(busNumber);;
        }
        else
        {
            wrongInputFormat();
            return;
        }
    }

    static void searchBus(int busNumber)
    {
        int counter = 0;
        for (Node student : list)
        {
            if(student.getBus() == busNumber)
            {
                counter++;
                System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " Grade: " + student.getGrade() + " Classroom: " + student.getRoom());
            }
        }
        if(counter == 0)
        {
            System.out.println("Not a valid bus route");
        }
    }

    static void parseInputForGrade(Scanner in)
    {
        int number = 0;
        String mode = "";

        if (in.hasNextInt())
        {
            number = in.nextInt();
            if (number > 6 || number < 0)
            {
                System.out.println("Not a valid grade");
                return;
            }
        }
        else
        {
            wrongInputFormat();
            return;
        }

        if (in.hasNext())
        {
            mode = in.next();
            if (mode.equals("High") || mode.equals("H"))
            {
                searchGrade(number, "h");
            }
            else if (mode.equals("Low") || mode.equals("L"))
            {
                searchGrade(number, "l");
            }
            else if(mode.equals("T") || mode.equals("Teacher"))
            {
                searchGrade(number, "t");
            }
            else
            {
                wrongInputFormat();
                return;
            }
        }
        else
        {
            searchGrade(number, "na");
        }
    }

    static void searchGrade(int number, String mode)
    {
        if (mode == "h")
        {
            highestGPA(number);
        }
        else if (mode == "l")
        {
            lowestGPA(number);
        }
        else if (mode == "na")
        {
            for (Node student : list)
            {
                if(student.getGrade() == number)
                {
                    System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
                }
            }
            if(arr[number] == 0)
            {
                System.out.println("No students in this grade");
            }
        }
        else if(mode == "t")
        {
            searchGradeTeacher(number);
        }
    }

    static void searchGradeTeacher(int grade)
    {
        ArrayList<String> teacherNames = new ArrayList<>();
        String TeacherName;
        boolean uniqueName = true;
        for (Node student : list)
        {
            uniqueName = true;
            if(student.getGrade() == grade)
            {
                TeacherName = student.getTeachFirst() + " " + student.getTeachLast();
                for(String name : teacherNames)
                {
                    if(name.equals(TeacherName))
                    {
                        uniqueName = false;
                    }
                }
                if(uniqueName)
                {
                    teacherNames.add(TeacherName);
                }
            }
        }

        for(String name : teacherNames)
        {
            System.out.println("Teacher: " + name);
        }
    }

    static void highestGPA(int grade){
      if(arr[grade] == 0){
         System.out.println("No students in this grade");
      }
      else{
         Node greatest = list.get(0);
         for(int i = 1; i < list.size(); i++){
            if(list.get(i).getGrade() == grade){
               if(list.get(i).getGpa() > greatest.getGpa()){
                  greatest = list.get(i);
               }
            }
         }
         printGrade(greatest);
      }
    }

    static void lowestGPA(int grade){
      if(arr[grade] == 0){
         System.out.println("No students in this grade");
      }
      else{
         Node lowest = list.get(0);
         for(int i = 1; i < list.size(); i++){
            if(list.get(i).getGrade() == grade){
               if(list.get(i).getGpa() <  lowest.getGpa()){
                  lowest = list.get(i);
               }
            }
         }
         printGrade(lowest);
      }
    }

    static void printGrade(Node n){
      System.out.println("Student: " + n.getFirstName() + " " + n.getLastName()
            + " GPA: " + n.getGpa() + " Teacher: " + n.getTeachFirst() + " " +
            n.getTeachLast() + " Bus Route: " + n.getBus());
    }

    static void parseInputForAverage(Scanner in)
    {
        int number = 0;
        if (in.hasNextInt())
        {
            number = in.nextInt();
            searchAverage(number);
        }
        else
        {
            wrongInputFormat();
            return;
        }
    }

    static void searchAverage(int number)
    {
        int counter = 0;
        float totalGPA = 0;
        for(Node n : list){
            if(n.getGrade() == number){
               totalGPA += n.getGpa();
               counter++;
            }
        }
        if(counter > 0){
           totalGPA = totalGPA / counter;
           System.out.println("Grade: " + number + " Average GPA: " + 
                              String.format("%.2f", totalGPA));
        }
        else{
           System.out.println("No students in this grade"); 
        }
    }

    static void studentsPerGrade(){
        for(int i = 0; i < 7; i++){
           int totalStudents = 0;
           for(int j = 0; j < list.size(); j++){
              if(list.get(j).getGrade() == i){
                  totalStudents++;
              }
           }
           arr[i] = totalStudents;
        }
    }

    static void getInfo()
    {
       System.out.println("G: # of students");
       for(int k = 0 ; k < arr.length; k++){
            System.out.println(k + ": "+ arr[k]);
        }
    }

    static void gradeSearchGPA(int grade){
       if(arr[grade] == 0){
         System.out.println("No students in this grade");
       }
       else{
         System.out.println("GPA for students in grade " + grade);
         for(Node n : list){
            if(n.getGrade() == grade){
               System.out.println(n.getGpa());
            }
         }
       }
    }

    static void parseInputForAnalytics(Scanner in){

       if(in.hasNext()){
         String cmd = in.next();
         if((cmd.equals("Grade") || cmd.equals("G"))  && in.hasNextInt()){
            int grade = in.nextInt();
            if((grade < 0) || (grade > 6)){
               System.out.println("Not a valid grade");
            }
            else{
               gradeSearchGPA(grade); 
            }    
         }
         else if((cmd.equals("Teacher") || cmd.equals("T")) && in.hasNext()){
            String lastname = in.next();
            //TODO teacherSearchGPA(lastname);
            System.out.println("cmd: " + cmd + "ln: " + lastname); 
         }

         else if((cmd.equals("Bus") || cmd.equals("B")) && in.hasNextInt()){
            int bus = in.nextInt();
            //TODO busSearchGPA(bus);
            System.out.println("cmd: " + cmd + "bus: " + bus); 
         }

         else{
            wrongInputFormat();  
         }
       }
       else{
         wrongInputFormat();
       }
    }

    static void parseInputForClassroom(Scanner in)
    {
        int classroom = 0;
        String mode = "";

        if (in.hasNextInt())
        {
            classroom = in.nextInt();
            if (classroom > 112 || classroom < 101)
            {
                System.out.println("Not a valid classroom number");
                return;
            }
        }
        else
        {
            wrongInputFormat();
            return;
        }

        if (in.hasNext())
        {
            mode = in.next();
            searchClassroom(classroom, mode);
        }
        else
        {
            wrongInputFormat();
            return;
        }
    }

    static void searchClassroom(int classroomNumber, String mode)
    {
        if (mode.equals("Student"))
        {
            int counter = 0;

            for (Node student : list)
            {
                if(student.getRoom() == classroomNumber)
                {
                    System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
                    counter++;
                }
            }
            if(counter == 0)
            {
                System.out.println("No students are assigned to this classroom number");
            }
            return;
        }
        else if (mode.equals("Teacher"))
        {
            for (Node student : list)
            {
                if (student.getRoom() == classroomNumber)
                {
                    System.out.println("Teacher: " + student.getTeachFirst() + " " + student.getTeachLast());
                    return;                
                }
            }
            System.out.println("No teacher is teaching in this classroom");
            return;
        }
        else
        {
            System.out.println("Invalid mode");
            return;
        }
    }

    static void parseInputForEnrollment(Scanner in)
    {
        if (in.hasNext())
        {
            wrongInputFormat();
            return;
        }
        else
        {
            searchClassroomEnrollment();
        }
    }

    static void searchClassroomEnrollment()
    {
        int[] enrollment = new int[12];
        int classroom;
        for(int i = 0; i<12; i++)
        {
            enrollment[i] = 0;
        }

        for(Node student : list)
        {
            classroom = student.getRoom();
            enrollment[classroom-101]++;
        }

        for(int j = 0; j<12; j++)
        {
            System.out.println("Classroom " + (j+101) + ": " + enrollment[j]);
        }
    }

    static void finishProgram()
    {
        System.out.println("Goodbye!");
        finishSearch = true;
    }

    static void wrongInputFormat()
    {
        System.out.println("Only these following command formats are supported:");
        System.out.print("S[tudent]: <lastname>[B[us]]"
              +"\nT[eacher]: <lastname>\nB[us]: <number>"
              +"\nG[rade]: <number> [H[igh]|L[ow]|T[eacher]]\nA[verage]: <number>"
              +"\nI[nfo]" 
              +"\nAn[alyticts]: G[rade] <number>|T[eacher] <lastname>|B[us] <number>" 
              +"\nC[lassroom]: <classroom number> Student|Teacher"
              +"\nE[nrollment]"
              +"\nQ[uit]\n");
        return;
    }

    static void fileToList(ArrayList<Node> nodeList){
      try{
         File file = new File("./list.txt");
         Scanner sc = new Scanner(file);
         while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            String [] split = line.split(",");
            Node n = new Node(split[0], split[1], 
                        Integer.parseInt(split[2]), //grade 
                        Integer.parseInt(split[3]), //class
                        Integer.parseInt(split[4]), // bus
                        Float.parseFloat(split[5]), // GPA
                        "", ""); //empty TlastName and TFirstName

            nodeList.add(n);
        }
         sc.close();
       }
       catch(IOException e){
         System.out.println("you shouldn't be seeing this error");
       }
    }


    static void addTeacher(ArrayList<Node> nodeList, String last, String first, int room){
      for(Node n : nodeList){
         if(n.getRoom() == room){
            n.setTeachLast(last);
            n.setTeachFirst(first);
         }
      } 
    }

    static void addTeacherToList(ArrayList<Node> nodeList){
      try{
         File teachers = new File("./teachers.txt");
         Scanner sc = new Scanner(teachers);
         while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            String [] split = line.split(", ");
            addTeacher(nodeList, split[0], split[1], Integer.parseInt(split[2])); 
         }
         sc.close();
      }
      catch(IOException e){
         System.out.println("you shouldn't be seeing this error"); 
      }
    }

    static boolean fileExists(){
      boolean result = false;
      File list = new File("./list.txt");
      File teachers = new File("./teachers.txt");
      if(list.exists() && teachers.exists()){
         result = true;
      }
      return result;
    }
}
