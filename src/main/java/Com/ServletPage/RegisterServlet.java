package Com.ServletPage;

import java.io.IOException;
import java.io.PrintWriter;

import Com.Student.Student;
import Com.StudentDao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	// This method handles POST requests (usually when the form is submitted)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
		    
		    // Retrieve form data
		    String idParam = request.getParameter("id");
		    Integer id = null; // Allow id to be null if not provided
		    if (idParam != null && !idParam.isEmpty()) {
		        try {
		            id = Integer.parseInt(idParam);
		        } catch (NumberFormatException e) {
		            out.print("<h3 style='color:red'>Invalid ID format. Please enter a valid number.</h3>");
		            return;
		        }
		    }

		    String name = request.getParameter("username");
		    String password = request.getParameter("password");
		    String email = request.getParameter("email");
		    String section = request.getParameter("section");

		    // Create Student object (id can be null)
		    Student student = new Student(id != null ? id : 0, name, email, password, section);

		    // Save student to the database
		    StudentDao studentDao = StudentDao.getInstance();
		    Student savedStudent = studentDao.saveData(student);

		    if (savedStudent != null) {
		        request.setAttribute("student", student);
		        request.getRequestDispatcher("display.jsp").forward(request, response);
		    } else {
		       // out.print("<h3 style='color:red'>Registration failed. Please try again.</h3>");
		    }
	}
}
