
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Podaj imię studenta:");
      String name = scanner.nextLine();
      
      System.out.println("Podaj wiek studenta:");
      int age = scanner.nextInt();
      
      s.addStudent(new Student(name, age));
      
      var students = s.getStudents();
      students.forEach(student -> System.out.println(student.ToString()));
      
      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}
