
public class Student {
  private String Name;
  private String Surname;
  private int Age;
  private String BirthDate;

  public Student(String name, String surname, int age, String birthDate) {
    Name = name;
    Surname = surname;
    Age = age;
    BirthDate = birthDate;
  }

  public String GetName() {return Name;}
  public String GetSurname() {return Surname;}
  public int GetAge() {return Age;}
  public String GetBirthDate() {return BirthDate;}

  public String ToString() {
    return Name + " " + Surname + " " + Integer.toString(Age) + " " + BirthDate;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4) 
      return new Student("Parse", "Error", -1, "01-01-1900");
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }

  public String getBirthDate() {
    return birthDate;
  }

  @Override
  public String toString() {
    return String.format("%s %s, wiek: %d, data urodzenia: %s", name, surname, age, birthDate);
  }
}
