package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null
                && !getAccounts(findByPassport(passport)).contains(account)) {
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

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account acc : getAccounts(findByPassport(passport))) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
       }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if ((findByPassport(srcPassport) != null)
                && (findByPassport(destPassport) != null)
                && (findByRequisite(srcPassport, srcRequisite) != null)
                && (findByRequisite(destPassport, destRequisite) != null)
                && ((findByRequisite(srcPassport, srcRequisite)).getBalance() >= amount)) {
            (findByRequisite(destPassport, destRequisite)).setBalance((findByRequisite(destPassport, destRequisite)).getBalance()
                    + amount);
            (findByRequisite(srcPassport, srcRequisite)).setBalance((findByRequisite(srcPassport, srcRequisite)).getBalance()
                    - amount);
            rsl = true;
        }
            return rsl;
        }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

