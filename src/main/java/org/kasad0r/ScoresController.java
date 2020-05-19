package org.kasad0r;

import org.kasad0r.domain.Score;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScoresController {
    private static final String filename = "score_user.data";
    public static List<Score> scoreList = new ArrayList<>();

    public void addNew(Score score) {
        scoreList.add(score);
        saveData();
    }

    public void saveData() {
        createIfNotExistAndEmptyCheck();
        try (var fos = new FileOutputStream(new File(filename));
             var oos = new ObjectOutputStream(fos)) {
            oos.writeObject(scoreList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreData() {
        if (!createIfNotExistAndEmptyCheck()) {
            try (var fis = new FileInputStream(new File(filename));
                 var oos = new ObjectInputStream(fis)) {
                List<Score> scores = (ArrayList<Score>) oos.readObject();
                if (scores != null) {
                    scoreList = scores;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean createIfNotExistAndEmptyCheck() {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {

            long size = Files.size(Paths.get(file.getAbsolutePath()));
            return size <= 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}
