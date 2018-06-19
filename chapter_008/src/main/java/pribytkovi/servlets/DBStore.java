package pribytkovi.servlets;

import java.sql.*;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBStore implements Store {
    private static final Logger log = LoggerFactory.getLogger(DBStore.class);
    String url;
    String driver;
    int initConnCnt;
    private static BasicDataSource  dataSource;
    private static BasicDataSource getDataSource() {
        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl("jdbc:postgresql://localhost:5432/contactdb");
            ds.setUsername("postgres");
            ds.setPassword("123");

            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
        return dataSource;
    }
    @Override
    public void add(String name, String password) {

        String sql = "INSERT INTO USERS (LOGIN, PASSWORD) VALUES (?, ?)";
        try (BasicDataSource dataSource = DBStore.getDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        )
        {
            System.out.println("The connection the connection Object is of Class: " + connection.getClass());
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(int id, String name, String password) {

    }

    @Override
    public User delete() {
        return null;
    }

    @Override
    public User[] findAll() {
        return new User[0];
    }

    @Override
    public User findBiId() {
        return null;
    }
    /*public Object ActionDatabase(String SAction) throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            String login = "postgres";
            String password = "123";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            List<User> users = UserStorage.getInstance().getUsers();
                while (rs.next()) {
                    User user = new User();
                    /*for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
                    }
                    String idi = rs.getString(1);
                    String name = rs.getString(2);
                    String email =rs.getString(3);
                    int id = Integer.parseInt(idi);
                    user.setId(id);
                    users.add(user);
                }
                rs.close();
                stmt.close();
            } finally{
            con.close();
            }
        } catch () {
        }
    }*/
}