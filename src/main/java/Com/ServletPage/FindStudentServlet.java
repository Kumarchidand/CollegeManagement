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

/** not use till now pending
 * Servlet implementation class FindStudentServlet
 */
@WebServlet("/findStudent")
public class FindStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FindStudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
//		String username=request.getParameter("username");
//		 String email=request.getParameter("email");	
		 StudentDao studentDao = StudentDao.getInstance();
	          
		 Student student = studentDao.findById(id);

	        if (student != null) {
	            request.setAttribute("student", student);
	            request.getRequestDispatcher("StudentDetails.jsp").forward(request, response);
	        } else {
	            request.setAttribute("error", "Student not found.");
	            request.getRequestDispatcher("TableOfStudent.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
