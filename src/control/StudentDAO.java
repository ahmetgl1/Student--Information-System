
package control;

import java.util.List;
import model.Student;



public interface StudentDAO {
    
public void save(Student students);
public void update(Student students);
public void delete(Student students);
public Student get(String id);
public List<Student> list();
    
    
    
}
