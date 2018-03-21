package ru.job4j.mapForBank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> map = new HashMap<User, List<Account>>();
    public void addUser(User user) {
        map.put(user, new ArrayList<Account>());
    }
    public void deleteUser(User user) {
        map.remove(user);
    }
    public void addAccountToUser(String pasport, Account account) {
        for(Map.Entry<User, List<Account>> item : map.entrySet()) {
            if (item.getKey().getPasport().equals(pasport)) {
                item.getValue().add(account);
                break;
            }
        }
    }
    public void deliteAccountFromUser(String pasport, Account account) {
        for (Map.Entry<User, List<Account>> item : map.entrySet()) {
            if (item.getKey().getPasport().equals(pasport)) {
                        item.getValue().remove(account);
                        break;
            }
        }
    }
    public List<Account> getUserAccount(String passport) {
        List<Account> acc = new ArrayList<Account>();
        for(Map.Entry<User, List<Account>> item : map.entrySet()) {
            if (item.getKey().getPasport().equals(passport)) {
                acc = item.getValue();
                break;
            }
        }    return acc;
    }


}
