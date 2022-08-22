package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.job4j.bank.User;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null && !getAccounts(findByPassport(passport)).contains(account)) {
            getAccounts(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
            break;
        }
        return null;
    }

        public Account findByRequisite (String passport, String requisite){
            return null;
        }

        public boolean transferMoney (String srcPassport, String srcRequisite,
                String destPassport, String destRequisite,double amount){
            boolean rsl = false;
            return rsl;
        }

    public List<Account> getAccounts (User user) {
        return users.get(user);
    }
}
}
