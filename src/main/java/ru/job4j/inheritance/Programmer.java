package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String lang;

    public Programmer(String name, String surname, String education, String birthday, int rank, String lang) {
        super(name, surname, education, birthday, rank);
        this.lang = lang;
    }

   public String getLang() {
       return lang;
    }

   public void startCode(Customer customer) {
       if (customer.getStatus() && lang == "Java") {
           System.out.println("Готов работать");
       } else {
           System.out.println("Не готов работать");
       }
   }
}
