
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      while (true) {
        System.out.println("\n1. Add new student");
        System.out.println("2. Show all students");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        
        if (choice == 1) {
          System.out.print("Enter student name: ");
          String name = scanner.nextLine();
          System.out.print("Enter student age: ");
          int age = scanner.nextInt();
          s.addStudent(new Student(name, age));
          System.out.println("Student added successfully!");
        } 
        else if (choice == 2) {
          var students = s.getStudents();
          for(Student current : students) {
            System.out.println(current.ToString());
          }
        }
        else if (choice == 3) {
          break;
        }
      }
      
      scanner.close();
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
