package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента банка, который включает в себя
 * паспортные данные и имя
 * @author Максим
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * Хранение информации происходит в объекте User
     * @param passport принимает паспортные данные в виде строки
     * @param username принимает ФИО в виде строки
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспортные данные клиента
     * @return возвращает паспортные данные в виде строки
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет записать паспортные данные объекту типа User
     * @param passport принимает паспортные данные в виде строки
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить ФИО клиента
     * @return возвращает ФИО в виде строки
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет записать ФИО объекту типа User
     * @param username принимает ФИО в виде строки
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод сравнения для объекта типа User
     * @param o принимает объект "о" для сравнения с другим объектом типа User
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенных хэш для объекта типа User
     * @return возвращает хэш паспортных данных
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
