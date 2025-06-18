package Com.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Com.Student.Student;

public class StudentDao implements StudenDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/studentmanagement";
	private static final String USER = "root";
	private static final String PASSWORD = "dbms123";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final StudentDao instance = new StudentDao();

	// Private constructor to enforce Singleton pattern
	private StudentDao() {

	}

	// Singleton instance getter
	public static StudentDao getInstance() {
		return instance;
	}

	// Method to establish a database connection
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public Student saveData(Student student) {
		String sql = "INSERT INTO data (id,username, email, password, section) VALUES (?,?, ?, ?, ?)";

		try {
			Class.forName(DRIVER);
			try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, student.getId());

				ps.setString(2, student.getUsername());
				ps.setString(3, student.getEmail());
				ps.setString(4, student.getPassword());
				ps.setString(5, student.getSection());

				int affectedRows = ps.executeUpdate();
				return affectedRows == 1 ? student : null;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateStudent(Student student) {
		String sql = "UPDATE data SET username=?,email=?, password=?,section=? WHERE id=?";
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, student.getUsername());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getPassword());
			ps.setString(4, student.getSection());

			ps.setInt(5, student.getId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Delete a student by ID
	public boolean deleteStudent(int id) {
		String sql = "DELETE FROM data WHERE id=?";
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id); // Use id as the identifier
			return ps.executeUpdate() > 0; // Return true if deleted
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Student findById(int id) {
		String sql = "SELECT id, username,  email,password, section FROM data WHERE id = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return new Student(rs.getInt("id"), rs.getString("username"), 
						rs.getString("email"), rs.getString("password"),rs.getString("section"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}

//	convert a ResultSet row to a Student object
	public Student getConvertRow(ResultSet set) throws SQLException {
		int id = set.getInt(1); // Fetching by column index
		String username = set.getString("username"); // Fetching by column name
		String email = set.getString("email");
		String password = set.getString("password");

		String section = set.getString("section");

		// Corrected return statement: Creating and returning a Student object
		return new Student(id, username, email, password, section);
	}

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub

		List<Student> list = new ArrayList<>();
		String sql = "select * from data";
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				list.add(getConvertRow(rs));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Student> findStudent(String username, String password) {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM data WHERE username=? AND password=?";
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(getConvertRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
