import java.sql.*;

public class Student {
    public static void addStudent(int id, String name, String email) throws SQLException {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO students VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setString(3, email);
        stmt.executeUpdate();
        System.out.println("Student Added!");
    }

    public static void showStudents() throws SQLException {
        Connection conn = DBConnection.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
        }
    }
}
