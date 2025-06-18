package Com.StudentDao;

import java.util.List;

import Com.Student.Student;

public interface StudenDAO {
//	   public int findById(Student name);
	   public Student saveData(Student student);
	   public boolean updateStudent(Student student);
	   public Student findById(int id);
	   boolean deleteStudent(int id);
	   List<Student> findAllStudent();
	   public List<Student>  findStudent(String username,String password);
	   
}
