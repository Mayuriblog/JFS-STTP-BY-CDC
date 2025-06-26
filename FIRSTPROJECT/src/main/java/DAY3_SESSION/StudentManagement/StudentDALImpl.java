package DAY3_SESSION.StudentManagement;

import java.util.*;

//student data access layer (DAL)
public class StudentDALImpl implements StudentDAL{
    private Map<Integer,Student> studentDB=new HashMap<>();
    public void addStudent(Student student)
    {
        studentDB.put(student.getId(),student);
    }
    public Student getStudentById(int id)
    {
        return studentDB.get(id);
    }
    public List<Student> getAllStudents()
    {
        return new ArrayList<>(studentDB.values());
    }
    public boolean updateStudentMarks(int id,double newMarks)
    {
        Student s=studentDB.get(id);
        if(s!=null)
        {
            s.setMarks(newMarks);
            return true;
        }
        return false;
    }
    public boolean deleteStudent(int id)
    {
        return studentDB.remove(id) !=null;
    }
}
