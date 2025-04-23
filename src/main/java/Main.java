
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      while (true) {
        System.out.println("\n1. Dodaj studenta");
        System.out.println("2. Pokaż studentów");
        System.out.println("3. wyjście");
        System.out.print("Wybierz opcję: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        if (choice == 1) {
          System.out.print("Wpisz imię studenta: ");
          String name = scanner.nextLine();
          System.out.print("Wpisz wiek studenta: ");
          int age = scanner.nextInt();
          s.addStudent(new Student(name, age));
          System.out.println("Student dodany");
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
