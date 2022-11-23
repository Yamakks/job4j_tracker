package ru.job4j.early;

import java.util.Locale;

public class PasswordValidator {
    @SuppressWarnings("checkstyle:NoWhitespaceBefore")
    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        String buf1 =password.toLowerCase();
        String buf2 = password.toUpperCase();
        if (password.length() <= 8 || password.length() >= 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
            if (buf1.equals(password)) {
                throw new IllegalArgumentException("Password should contain at least one uppercase letter");
            }
            if (buf2.equals(password)) {
                throw new IllegalArgumentException("Password should contain at least one lowercase letter");
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
