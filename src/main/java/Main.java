import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collection;



public class Main {
    public static void main(String[] args) throws IOException {
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1 - Dodaj studenta");
            System.out.println("2 - Wyświetl wszystkich studentów");
            System.out.println("3 - Zakończ program");
            System.out.print("Wybierz opcję: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość. Spróbuj ponownie.");
                scanner.nextLine(); 
                continue;
            }

            switch (choice) {
                case 1:
                try {
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

                    if (day < 1 || day > 31) {
                        System.out.println("Błędny dzień. Powinien być w zakresie 1-31.");
                        break;
                    }

                    System.out.println("Podaj miesiąc urodzenia (1-12):");
                    int month = scanner.nextInt();
                    scanner.nextLine();

                    if (month < 1 || month > 12) {
                        System.out.println("Błędny miesiąc. Powinien być w zakresie 1-12.");
                        break;
                    }

                    System.out.println("Podaj rok urodzenia (1900-2025):");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    if (year < 1900 || year > 2025) {
                        System.out.println("Błędny rok. Powinien być w zakresie 1900-2025.");
                        break;
                    }

                    String birthDate = String.format("%02d-%02d-%d", day, month, year);
                    Student newStudent = new Student(name, surname, age, birthDate);

                    s.addStudent(newStudent);
                    System.out.println("Dodano studenta!");
                } catch (Exception e) {
                    System.out.println("Wystąpił błąd.");
                    scanner.nextLine();
                }
                break;

                case 2:
                    System.out.println("Lista wszystkich studentów:");
                    Collection<Student> students = s.getStudents();
                    if (students.isEmpty()) {
                        System.out.println("Brak zapisanych studentów.");
                    } else {
                        students.forEach(student -> System.out.println(student.toString()));
                    }
                    break;

                case 3:
                    System.out.println("Program zakończony.");
                    exit = true;
                    break;

                default:
                    System.out.println("Nieprawidłowa opcja!");
            }
        }

        scanner.close();
    }
}