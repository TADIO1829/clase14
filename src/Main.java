
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            //prepara la sentencia sql
            String sql = "UPDATE estudiantes SET b1 = ? WHERE cedula = ?";
            pstmt = conn.prepareStatement(sql);
            //seteamos los valores
            pstmt.setInt(1, 20);
            pstmt.setString(2, "1741077984");
            System.out.println(sql);
            int n = pstmt.executeUpdate();
            System.out.println("Se modifico" + n);
        } catch (SQLException e) {
            System.out.println("XD");


        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("XD");


            }


        }
    }
}
