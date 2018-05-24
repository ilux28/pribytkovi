package jdbc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JdbcTest {
    private static final Logger log = LoggerFactory.getLogger(JdbcTest.class);

    public static void main(String[] args) {
        String url = "jdbc:postrgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "123";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELRCT * FROM comments WHERE id = 1");
            while (rs.next()) {
                System.out.println(rs.getString("id"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }

            }
        }
    }
}
