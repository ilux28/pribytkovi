package pribytkovi.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class UserStorage {
    private static final Logger Log = LoggerFactory.getLogger(UserStorage.class);

    private static final UserStorage instance = new UserStorage();
    private List<User> users = new CopyOnWriteArrayList<User>();

    private UserStorage() {
    }

    public static UserStorage getInstance() {
        return instance;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }
    public boolean isCredentional(String name, String password) {
        boolean exist = false;
        for (User user : this.users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                exist = true;
                break;
            }
        } return exist;
    }
}

