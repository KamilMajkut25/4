
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("1 - Dodaj studenta");
      System.out.println("2 - Wyświetl wszystkich studentów");
      System.out.print("Wybierz opcję: ");
      
      int choice = scanner.nextInt();
      scanner.nextLine(); // consume newline
      
      if (choice == 1) {
        System.out.println("Podaj imię studenta:");
        String name = scanner.nextLine();
        
        System.out.println("Podaj wiek studenta:");
        int age = scanner.nextInt();
        
        s.addStudent(new Student(name, age));
        System.out.println("Dodano studenta!");
      } else if (choice == 2) {
        System.out.println("Lista wszystkich studentów:");
        s.getStudents().forEach(student -> System.out.println(student.ToString()));
      }
      
      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}
