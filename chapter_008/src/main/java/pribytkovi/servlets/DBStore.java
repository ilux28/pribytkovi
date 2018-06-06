package pribytkovi.servlets;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBStore implements Store {
    private static final Logger log = LoggerFactory.getLogger(DBStore.class);

    String url = "jdbc:postrgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "123";
    Connection con = null;




    @Override
    public void add() {

    }

    @Override
    public void update() {

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
}
