import java.sql.*;

public class Enrollment {
    public static void enrollStudent(int studentId, int courseId, String grade) throws SQLException {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO enrollments (student_id, course_id, grade) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, studentId);
        stmt.setInt(2, courseId);
        stmt.setString(3, grade);
        stmt.executeUpdate();
        System.out.println("Student Enrolled!");
    }

    public static void showGrades() throws SQLException {
        Connection conn = DBConnection.connect();
        String sql = "SELECT s.name, c.course_name, e.grade " +
                     "FROM enrollments e " +
                     "JOIN students s ON e.student_id = s.student_id " +
                     "JOIN courses c ON e.course_id = c.course_id";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
        }
    }
}
