package pribytkovi.servlets;

public interface Store {

    public void add(String name, String password);
    public void update(int id, String name, String password);
    public User delete();
    public User[] findAll();
    public User findBiId();
}
