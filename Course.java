import java.sql.*;

public class Course {
    public static void addCourse(int id, String name, int credits) throws SQLException {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO courses VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setInt(3, credits);
        stmt.executeUpdate();
        System.out.println("Course Added!");
    }

    public static void showCourses() throws SQLException {
        Connection conn = DBConnection.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM courses");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3));
        }
    }
}
