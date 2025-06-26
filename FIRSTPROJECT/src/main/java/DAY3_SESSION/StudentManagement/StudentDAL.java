package DAY3_SESSION.StudentManagement;
import java.util.*;
public interface StudentDAL {
    void addStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    boolean updateStudentMarks(int id,double newMarks);
    boolean deleteStudent(int id);
}
