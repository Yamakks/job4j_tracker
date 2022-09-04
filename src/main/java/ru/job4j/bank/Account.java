package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает аккаунт клиента банка, который включает в себя
 * реквизиты счета и баланс
 * @author job4j.ru
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Хранение информации происходит в объекте Account
     * @param requisite принимает тип данных строку, содержит реквизиты
     * @param balance принимает тип данных дабл, содержит баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты
     * @return возвращает реквизиты в виде строки
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет назначить реквизиты объекту типа Account
     * @param requisite принимает реквизиты в виде строки
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс
     * @return возвращает баланс в виде числа дабл
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет назначить баланс объекту типа Account
     * @param balance принимает баланс в виде числа дабл
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод сравнения для объекта типа Account
     * @param o принимает объект "о" для сравнения с другим объектом типа Account
     * @return true если объекты совпадают или false, если отличаются
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенных хэш для объекта типа Account
     * @return возвращает хэш реквизитов
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
