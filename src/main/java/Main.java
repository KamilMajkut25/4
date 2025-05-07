import java.io.IOException; 
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.println("1 - Dodaj studenta");
      System.out.println("2 - Wyświetl wszystkich studentów");
      System.out.println("3 - Zakończ program");
      System.out.print("Wybierz opcję: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // konsumpcja nowej linii

      switch (choice) {
        case 1:
          System.out.println("Podaj imię studenta:");
          String name = scanner.nextLine();

          System.out.println("Podaj nazwisko studenta:");
          String surname = scanner.nextLine();

          System.out.println("Podaj wiek studenta:");
          int age = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Podaj dzień urodzenia (1-31):");
          int day = scanner.nextInt();
          scanner.nextLine();

          System.out.println("Podaj miesiąc urodzenia (1-12):");
          int month = scanner.nextInt();
          scanner.nextLine();

          System.out.println("Podaj rok urodzenia (1900-2025):");
          int year = scanner.nextInt();
          scanner.nextLine();

         
          String birthDate = String.format("%02d-%02d-%d", day, month, year);
          Student newStudent = new Student(name, surname, age, birthDate);

          s.addStudent(newStudent);
          System.out.println("Dodano studenta!");
          break;

        case 2:
          System.out.println("Lista wszystkich studentów:");
          s.getStudents().forEach(student ->      System.out.println(student.ToString()));
          break;

        case 3:
          System.out.println("Program zakończony.");
          System.exit(0);
          break;

        default:
          System.out.println("Nieprawidłowa opcja!");
      }

      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}