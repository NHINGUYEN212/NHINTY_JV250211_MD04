package ra.com.exercise1234.repository;

import org.springframework.stereotype.Repository;
import ra.com.exercise1234.model.Student;
import ra.com.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    public boolean addStudent(Student student) {
        Connection conn = null;
        CallableStatement callStmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call add_student(?,?,?,?)}");
            callStmt.setString(1, student.getStudentName());
            callStmt.setString(2, student.getEmail());
            callStmt.setDate(3, java.sql.Date.valueOf(student.getBirthDate()));
            callStmt.setDouble(4, student.getAvgMark());
            callStmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return result;
    }

    public boolean updateStudentById(Student student) {
        Connection conn = null;
        CallableStatement callStmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call update_student(?,?,?,?,?)}");
            callStmt.setInt(1, student.getId());
            callStmt.setString(2, student.getStudentName());
            callStmt.setString(3, student.getEmail());
            callStmt.setDate(4, java.sql.Date.valueOf(student.getBirthDate()));
            callStmt.setDouble(5, student.getAvgMark());
            callStmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return result;
    }

    public Student getStudentById(int id) {
        Connection conn = null;
        CallableStatement callStmt = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call get_student_by_id(?)}");
            callStmt.setInt(1, id);
            ResultSet rs = callStmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setEmail(rs.getString("email"));
                student.setBirthDate(LocalDate.parse(rs.getString("birthday")));
                student.setAvgMark(rs.getDouble("avg_mark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return student;
    }

    public boolean deleteStudentById(Integer id) {
        Connection conn = null;
        CallableStatement callStmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call delete_student(?)}");
            callStmt.setInt(1, id);
            callStmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return result;
    }

    public List<Student> getAllStudents(String search, String sort) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Student> students = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call get_all_students(?,?)}");
            callStmt.setString(1, search);
            callStmt.setString(2, sort);
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setEmail(rs.getString("email"));
                student.setBirthDate(LocalDate.parse(rs.getString("birthday")));
                student.setAvgMark(rs.getDouble("avg_mark"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return students;
    }
}
