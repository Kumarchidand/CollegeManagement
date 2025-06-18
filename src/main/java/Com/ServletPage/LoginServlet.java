package Com.ServletPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Com.Student.Student;
import Com.StudentDao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class LoginServlet extends HttpServlet {

	public StudentDao dao = StudentDao.getInstance(); // Correct initialization

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 1️⃣ **Check for empty fields**
		if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
			request.setAttribute("error", "Username and Password cannot be empty.");
			request.getRequestDispatcher("profile.jsp").forward(request, response);

		}

		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root",
					"dbms123");
			PreparedStatement ps = con.prepareStatement("select * from data where username=? and password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			
			
			if (rs.next()) {
				request.setAttribute("success", "login happens");
				request.setAttribute("username", username);
				
				
				request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Invalid username or password.");
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Invalid username or password.");
			request.getRequestDispatcher("profile.jsp").forward(request, response);

		}

		// 2️⃣ **Validate user from the database**
//		StudentDao dao=StudentDao.getInstance();
//		Student student = dao.findStudent(username, password); // Correct usage of 'dao'
//
//		if (student != null) {
//			// Redirect user to display.jsp after successful login
//			request.setAttribute("success", student);
//			request.getRequestDispatcher("profile.jsp").forward(request, response);
//		} else {
//			// If invalid credentials, stay on profile.jsp and show error message
//			request.setAttribute("error", "Invalid username or password.");
//			request.getRequestDispatcher("profile.jsp").forward(request, response);
//		}
	}
}
