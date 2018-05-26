package pribytkovi.servlets;

public interface Store {

    public void add();
    public void update();
    public User delete();
    public User[] findAll();
    public User findBiId();
}
