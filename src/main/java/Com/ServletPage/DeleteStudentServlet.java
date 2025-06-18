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

/**
 * You are deleting by link, so doGet() is right here. If you change it to a
 * form with method="post", shift your delete logic to doPost(). Use doGet() for
 * reading/showing data, and doPost() for sending/changing data. Calling doGet()
 * from doPost() is just code reuse.
 * 
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));

		StudentDao studentDao = StudentDao.getInstance();
		boolean deleted = studentDao.deleteStudent(id);

		if (deleted) {
			request.setAttribute("message", "Student deleted successfully!");
		} else {
			request.setAttribute("error", "Failed to delete student.");
		}

		// Fetch updated student list after deletion
		List<Student> students = studentDao.findAllStudent();
		request.setAttribute("students", students);
		// Redirect to student list page
		request.getRequestDispatcher("TableOfStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
