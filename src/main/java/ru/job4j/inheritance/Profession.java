package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        Programmer iAm;
        iAm = new Programmer("Антон", "Первый", "Высшее", "10.10.1990", 0, "Python");
        Programmer notIam;
        notIam = new Programmer("неАнтон", "Второй", "Высшее", "10.10.1992", 1, "Java");
        System.out.println(notIam.getName());
        System.out.println(notIam.getLang());
        Customer customer1 = new Customer("Paul", 10050, true);
iAm.startCode(customer1);
    }
}
