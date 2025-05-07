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
      scanner.nextLine(); 

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
          case "4":
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
          String name = scanner.nextLine();
          List<Student> studentsByName = s.findStudentsByName(name);
          if (studentsByName.isEmpty()) {
           System.out.println("Brak studentów o tym imieniu.");
          } else {
          studentsByName.forEach(student -> System.out.println(student.toString()));
          }
          break;
          case "b":
          System.out.println("Podaj nazwisko:");
          String surname = scanner.nextLine();
          List<Student> studentsBySurname = s.findStudentsBySurname(surname);
          if (studentsBySurname.isEmpty()) {
                                          System.out.println("Brak studentów o tym nazwisku.");
                                      } else {
                                          studentsBySurname.forEach(student -> System.out.println(student.toString()));
                                      }
                                      break;
                                  case "c":
                                      System.out.println("Podaj wiek:");
                                      int ageFilter;
                                      try {
                                          ageFilter = scanner.nextInt();
                                          scanner.nextLine();
                                      } catch (Exception e) {
                                          System.out.println("Nieprawidłowa wartość wieku.");
                                          scanner.nextLine();
                                          break;
                                      }
                                      List<Student> studentsByAge = s.filterStudentsByAge(ageFilter);
                                      if (studentsByAge.isEmpty()) {
                                          System.out.println("Brak studentów o tym wieku.");
                                      } else {
                                          studentsByAge.forEach(student -> System.out.println(student.toString()));
                                      }
                                      break;
                                  case "d":
                                      System.out.println("Podaj miesiąc urodzenia (1-12):");
                                      int month;
                                      try {
                                          month = scanner.nextInt();
                                          scanner.nextLine();
                                          if (month < 1 || month > 12) {
                                              System.out.println("Nieprawidłowy miesiąc.");
                                              break;
                                          }
                                      } catch (Exception e) {
                                          System.out.println("Nieprawidłowa wartość.");
                                          scanner.nextLine();
                                          break;
                                      }
                                      List<Student> studentsByBirthMonth = s.filterStudentsByBirthMonth(month);
                                      if (studentsByBirthMonth.isEmpty()) {
                                          System.out.println("Brak studentów urodzonych w tym miesiącu.");
                                      } else {
                                          studentsByBirthMonth.forEach(student -> System.out.println(student.toString()));
                                      }
                                      break;
                                  default:
                                      System.out.println("Nieprawidłowy wybór kryterium.");
                              }
                              break;
                          case "5":
                              System.out.println("Do widzenia!");
                              scanner.close();
                              return;
                          default:
                              System.out.println("Nieprawidłowa opcja!");
                      }
                  }
                  } catch (IOException e) {
                      System.out.println("Błąd podczas operacji na pliku: " + e.getMessage());
                  }
              }
          }

        default:
          System.out.println("Nieprawidłowa opcja!");
      }

      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}