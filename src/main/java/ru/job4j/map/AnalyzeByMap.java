package ru.job4j.map;

import java.util.List;

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
       double score = 0D;
       int index = 0;
       int indexOfScore = 0;
        Label[] rsl = new Label[pupils.size()];
        for (Pupil pupil : pupils) {
            indexOfScore = 0;
            for (Subject subject : pupil.subjects()) {
                score *= indexOfScore;
                indexOfScore = 1;
                score += (double) subject.score() / pupil.subjects().size();
            }
            rsl[index] = new Label(pupil.name(), score);
            index++;
        }

        return List.of(rsl);
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return List.of();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }

}
