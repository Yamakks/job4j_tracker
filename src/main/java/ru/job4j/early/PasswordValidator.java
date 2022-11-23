package ru.job4j.early;

public class PasswordValidator {
    @SuppressWarnings("checkstyle:NoWhitespaceBefore")
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() <= 8 || password.length() >= 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (int i = 0; i < password.length(); i++) {

            if ((password.charAt(i)).isUpperCase) {
                break;
                throw new IllegalArgumentException("Password can't be null");
            }
            if (password == null) {
                throw new IllegalArgumentException("Password can't be null");
            }
            if (password == null) {
                throw new IllegalArgumentException("Password can't be null");
            }
            if (password == null) {
                throw new IllegalArgumentException("Password can't be null");
            }
            if (password == null) {
                throw new IllegalArgumentException("Password can't be null");
            }
        }

    }
}
