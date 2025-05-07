
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service s = new Service();

        while (true) {
            System.out.println("\n1. Dodaj studenta");
            System.out.println("2. Wyświetl wszystkich studentów");
            System.out.println("3. Znajdź studenta");
            System.out.println("4. Wyszukaj studentów");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję: ");

            String choice = scanner.nextLine();
            
            switch (choice) {
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
    }
}
