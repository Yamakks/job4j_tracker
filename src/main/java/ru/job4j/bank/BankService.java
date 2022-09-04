package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает простейший банковский сервис,
 * который позволяет добавлять и хранить информацию о клиентах банка и их счетах.
 * Информация включает в себя:
 * ФИО клиента, паспортные данные клиента, банковские счета клиента
 * Имеется возможность производить трансфер средств между счетами
 * @author Максим
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение информации осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового клиента в коллекцию хэшмап
     * @param user принимает тип данных User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет сведения о счетах клиенту
     * @param passport принимает паспортные данные клиента в виде строки
     * @param account принимает сведения о счетах
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
            getAccounts(user).add(account);
        }
    }

    /**
     * Метод ищет клиента банка по паспортным данным
     * @param passport принимает паспортные данные в виде строки
     * @return если клиент с запрашиваемыми паспортными данными существует
     * метод возвращает объект типа User, в ином случае null
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет у клиента банка по его реквизитам
     * @param passport принимает паспортные данные в виде строки
     * @param requisite принимает реквизиты счета в виде строки
     * @return если клиент с запрашиваемыми паспортными данными существует
     * и у этого клиента имеется запрашиваемый счет
     * метод возвращает объект типа Account, в ином случае null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : getAccounts(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
       }
        return null;
    }

    /**
     * Метод позволяет производить трансфер средств между счетами
     * @param srcPassport принимает паспортные данные клиента отправителя
     * @param srcRequisite принимает реквизиты счета списания
     * @param destPassport принимает паспортные данные клиента получателя
     * @param destRequisite принимает реквизиты счета зачисления
     * @param amount принимает сумму перевода
     * @return при успешном трансфере true, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite), destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null
                && destAcc != null
                && srcAcc.getBalance() >= amount) {
            destAcc.setBalance(destAcc.getBalance() + amount);
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            rsl = true;
        }
            return rsl;
        }

    /**
     * Метод получения аккаунтов клиента
     * @param user принимает объект типа User
     * @return возвращает список счетав пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

