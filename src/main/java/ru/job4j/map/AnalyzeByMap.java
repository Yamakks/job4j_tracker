package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int rsl = 0;
        int sum = 0;
        for (Pupil pupil : pupils) {
           for (Subject subject : pupil.subjects()) {
               rsl += subject.score();
               sum++;
           }
        }
        return (double) rsl / sum;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum = sum + subject.score();
            }
            labels.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int buf = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), buf + subject.score());
            }
        }
        for (String subjectName : map.keySet()) {
            labels.add(new Label(subjectName, (double) map.get(subjectName) / pupils.size()));
        }

        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum = sum + subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int buf = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), buf + subject.score());
            }
        }
        for (String subjectName : map.keySet()) {
            labels.add(new Label(subjectName, (double) map.get(subjectName)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

}
