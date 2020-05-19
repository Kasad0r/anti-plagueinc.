package org.kasad0r.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Score implements Serializable {
    public String name;
    public long scores;
    public LocalDate localDate;
    public Difficulty difficulty;


    @Override
    public String toString() {
        return  name + "    scores: " + scores + "   date: " + localDate + "    diff: " + difficulty;
    }


    public long getScores() {
        return scores;
    }

}
