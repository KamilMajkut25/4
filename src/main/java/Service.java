import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    var students = reader.lines()
                        .map(Student::Parse)
                        .toList();
    reader.close();
    return students;
  }

  public Student findStudentByName(String name) {
    return null;
  }
}