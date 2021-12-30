
package control;

import database.StudentDB;
import java.util.List;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class StudentDAOImplement implements StudentDAO{

    @Override
    public void save(Student students) {
       
        try {
           
            Connection connect = StudentDB.getConnection();
           
        
             String sql = "INSERT INTO ınformations(id,name,course,price) VALUES (?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            //sonradan eklendi . 
            ps.setString(1, students.getId());
            ps.setString(2, students.getFname());
            ps.setString(3, students.getCourse());
            ps.setInt(4, students.getPrice());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SAVED !"); 
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR !");
            System.out.println("ERROR CODE"+e.getMessage());
        }
        
        
        
        
        
        
        
    }

    @Override
    public void update(Student students) {
       
        try {
            Connection connect  = StudentDB.getConnection();
            String sql ="UPDATE ınformations SET fname =? , course= ? , price = ? WHERE  id=?"; 
            //  String sql ="UPDATE studentınformation SET fname =? , course= ? , price = ? WHERE  id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, students.getFname());
            ps.setString(2, students.getCourse());
            ps.setInt(3, students.getPrice());
            ps.setString(4, students.getId());
            
            ps.executeUpdate();
            
            
            
            JOptionPane.showMessageDialog(null, "UPDATE !");
            
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR  CODE !"+ e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR !");
        }
        
     
        
    }

    @Override
    public void delete(Student students) {
        
        
        try {
            Connection connect =  StudentDB.getConnection();
            String sql = "Delete from ınformations where id = ?";
            //String sql = "Delete from studentınformation where id = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, students.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DELETED !");
            
        } 
        catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("ERROR CODE :" + e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR  ");
            
            
        }
        
        
        
    }

    @Override
    public Student get(String id) {
          
        Student st = new Student();
        
        try {
            Connection connect = StudentDB.getConnection();
            String sql =  "Select * From ınformations Where  id= ?";
           // String sql =  "Select * From studentınformation Where  id= ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                st.setId(rs.getString("id"));
                st.setFname(rs.getString("name"));
                st.setCourse(rs.getString("course"));
                st.setPrice(rs.getInt("price"));

            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR !");
            System.out.println("ERROR CODE :" + e.getMessage());
      
        }
        return  st;
}
      

    @Override
    public List<Student> list() {

          List<Student> list = new ArrayList<Student>();
    
          try{
              Connection connect = StudentDB.getConnection();
             
              //String sql = "SELECT * FROM  studentınformations";
              String sql = "SELECT * FROM  ınformations";
              PreparedStatement ps = connect.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              
              while(rs.next()){
                 Student st = new Student();
                 st.setId(rs.getString("id"));
                 st.setFname(rs.getString("name"));
                 st.setCourse(rs.getString("course"));
                 st.setPrice(rs.getInt("price"));
                 
                 
                 list.add(st);          
                 
              }
              
          }
          catch(Exception e){
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "EhhhRROR !");
              System.out.println("ERROR CODE :" + e.getMessage());
          }
          
return list;
    }
    
    
}
