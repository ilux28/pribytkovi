package pribytkovi.servlets;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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
        String sql = "INSERT INTO USERS (LOGIN, PASSWORD) VALUES (?, ?)";
        try (BasicDataSource dataSource = DBStore.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        PreparedStatement prst = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS"))
        {
            System.out.println("The connection Objects is of Class: " + connection.getClass());
            while (rs.next()) {
                if (rs.getInt(1) == id) {
                    prst.setString(1, name);
                    prst.setString(2, password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public ResultSet delete(String name) {
        ResultSet rs = null;
        try (BasicDataSource dataSource = DBStore.getDataSource();
             Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery("DELETE FROM USERS WHERE login == name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    @Override
    public User[] findAll() {
        ArrayList<User> listUsers = new ArrayList<>();
        try (BasicDataSource dataSource = DBStore.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS")) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                listUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User[] users = listUsers.toArray(new User[listUsers.size()]);
        return users;
    }
    @Override
    public User findBiId(int id) {
        User user = new User();
        try (BasicDataSource dataSource = DBStore.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS")) {
            while (rs.next()) {
                if (rs.getInt(1) == id) {
                     user.setId(id);
                     user.setName(rs.getString(2));
                     user.setEmail(rs.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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