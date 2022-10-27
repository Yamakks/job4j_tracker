package ru.job4j.map;

import java.util.Map;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Student findByAccount(String account) {
        Student rsl = null;
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = s;
                break;
            }
        }
        return rsl;
    }

    public Subject findBySubjectName(String account, String name) {
        Subject rsl = null;
        Student s = findByAccount(account);
        if (s != null) {
            Set<Subject> subjects = students.get(s);
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = subj;
                    break;
                }
            }
        }
        return rsl;
    }
}
