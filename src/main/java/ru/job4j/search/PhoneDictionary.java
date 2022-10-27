package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> containName = per -> per.getName().contains(key);
        Predicate<Person> containPhone = per -> per.getPhone().contains(key);
        Predicate<Person> containAdress = per -> per.getAddress().contains(key);
        Predicate<Person> containSurname = per -> per.getSurname().contains(key);
        Predicate<Person> combine = containName.or(containPhone.or(containAdress.or(containSurname)));
        var result = new ArrayList<Person>();
        for (var per : persons) {
            if (combine.test(per)) {
                result.add(per);
            }
        }
        return result;
    }
}
