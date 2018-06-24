package pribytkovi.servlets;

import java.sql.ResultSet;

public interface Store {

    public void add(String name, String password);
    public void update(int id, String name, String password);
    public ResultSet delete(String name);
    public User[] findAll();
    public User findBiId(int id);
}
