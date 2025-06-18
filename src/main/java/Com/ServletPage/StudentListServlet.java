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

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDao studentDao = StudentDao.getInstance(); // Get DAO instance
		List<Student> students = studentDao.findAllStudent(); // Fetch all students

		request.setAttribute("students", students); // Set student list in request scope
		request.getRequestDispatcher("TableOfStudent.jsp").forward(request, response); // Forward to JSP
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
