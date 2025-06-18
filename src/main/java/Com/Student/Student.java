package Com.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//data fields
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private int id;
    private String  username;
    private String email;
    private String password;
    private String section;
}
