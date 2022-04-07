package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Наличие ошибки: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Описание ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error404 = new Error(true, 404, "Страница отсутствует");
        Error error2 = new Error(false, -1, "Ошибки отсутствуют");
        error.printInfo();
        error404.printInfo();
        error2.printInfo();
    }
}
