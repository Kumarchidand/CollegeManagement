package Com.ServletPage;

import java.io.IOException;
import java.util.List;

import Com.Student.Student;
import Com.StudentDao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		// Fetch student data using DAO
		Student student = StudentDao.getInstance().findById(id);

		// Forward to the update form with student data
		request.setAttribute("student", student);
		request.getRequestDispatcher("updateStudentForm.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String section = req.getParameter("section");


		// Update student object
		Student student = new Student(id, username, email,  password,section);
		StudentDao student1 = StudentDao.getInstance();
		// Update in the database
		boolean success = student1.updateStudent(student);
		List<Student> students = student1.findAllStudent();
        req.setAttribute("students", students);
        req.getRequestDispatcher("TableOfStudent.jsp").forward(req, resp);;
//	
	}

}
