import java.io.IOException; 
import java.util.Scanner;
import java.util.List;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while(true) {
        System.out.println("\n1 - Dodaj studenta");
        System.out.println("2 - Wyświetl wszystkich studentów");
        System.out.println("3 - Wyszukaj studentów");
        System.out.println("4 - Zakończ program");
        System.out.print("Wybierz opcję: ");

        String choice = scanner.nextLine();

        switch (choice) {
          case "1":
            System.out.println("Podaj imię studenta:");
            String name = scanner.nextLine();

            System.out.println("Podaj nazwisko studenta:");
            String surname = scanner.nextLine();

            System.out.println("Podaj wiek studenta:");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.println("Podaj dzień urodzenia (1-31):");
            int day = Integer.parseInt(scanner.nextLine());

            System.out.println("Podaj miesiąc urodzenia (1-12):");
            int month = Integer.parseInt(scanner.nextLine());

            System.out.println("Podaj rok urodzenia (1900-2025):");
            int year = Integer.parseInt(scanner.nextLine());

            String birthDate = String.format("%02d-%02d-%d", day, month, year);
            Student newStudent = new Student(name, surname, age, birthDate);
            s.addStudent(newStudent);
            System.out.println("Dodano studenta!");
            break;

          case "2":
            System.out.println("Lista wszystkich studentów:");
            s.getStudents().forEach(student -> System.out.println(student.ToString()));
            break;

          case "3":
            System.out.println("Wybierz kryterium wyszukiwania:");
            System.out.println("a - według imienia");
            System.out.println("b - według nazwiska");
            System.out.println("c - według wieku");
            System.out.println("d - według miesiąca urodzenia");
            System.out.print("Wybierz opcję: ");
            String searchChoice = scanner.nextLine();

            switch (searchChoice.toLowerCase()) {
              case "a":
                System.out.println("Podaj imię:");
                String searchName = scanner.nextLine();
                List<Student> studentsByName = s.findStudentsByName(searchName);
                if (studentsByName.isEmpty()) {
                  System.out.println("Brak studentów o tym imieniu.");
                } else {
                  studentsByName.forEach(student -> System.out.println(student.toString()));
                }
                break;

              case "b":
                System.out.println("Podaj nazwisko:");
                String searchSurname = scanner.nextLine();
                List<Student> studentsBySurname = s.findStudentsBySurname(searchSurname);
                if (studentsBySurname.isEmpty()) {
                  System.out.println("Brak studentów o tym nazwisku.");
                } else {
                  studentsBySurname.forEach(student -> System.out.println(student.toString()));
                }
                break;

              case "c":
                System.out.println("Podaj wiek:");
                try {
                  int searchAge = Integer.parseInt(scanner.nextLine());
                  List<Student> studentsByAge = s.filterStudentsByAge(searchAge);
                  if (studentsByAge.isEmpty()) {
                    System.out.println("Brak studentów o tym wieku.");
                  } else {
                    studentsByAge.forEach(student -> System.out.println(student.toString()));
                  }
                } catch (NumberFormatException e) {
                  System.out.println("Nieprawidłowa wartość wieku.");
                }
                break;

              case "d":
                System.out.println("Podaj miesiąc urodzenia (1-12):");
                try {
                  int searchMonth = Integer.parseInt(scanner.nextLine());
                  if (searchMonth < 1 || searchMonth > 12) {
                    System.out.println("Nieprawidłowy miesiąc.");
                    break;
                  }
                  List<Student> studentsByBirthMonth = s.filterStudentsByBirthMonth(searchMonth);
                  if (studentsByBirthMonth.isEmpty()) {
                    System.out.println("Brak studentów urodzonych w tym miesiącu.");
                  } else {
                    studentsByBirthMonth.forEach(student -> System.out.println(student.toString()));
                  }
                } catch (NumberFormatException e) {
                  System.out.println("Nieprawidłowa wartość.");
                }
                break;

              default:
                System.out.println("Nieprawidłowy wybór kryterium.");
            }
            break;

          case "4":
            System.out.println("Do widzenia!");
            scanner.close();
            return;

          default:
            System.out.println("Nieprawidłowa opcja!");
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd podczas operacji na pliku: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Błąd: Wprowadzono nieprawidłową wartość liczbową.");
    }
  }
}