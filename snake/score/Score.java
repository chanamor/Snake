package score;

import java.io.*;
import java.util.*;

//ใช้ record เพื่อให้เขียนส่วน get แทน
public record Score(String playerName, int score) implements Comparable<Score> {

    @Override
    public int compareTo(Score other) {
        // เรียงคะแนนมากไปน้อย
        return Integer.compare(other.score(), this.score());
    }

    public String toString() {
        //เว้นพื้นที่ให้ดูเป็นระเบียบ
        return String.format("%-20s: %d", playerName, score);
    }
    
    public static ArrayList<Score> getHighScores() {
        File f = new File("./Nameplayer/NAME_SCORE.csv");
        ArrayList<Score> scoreList = new ArrayList<>();
        if (!f.exists()) {
            return scoreList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    try {
                        scoreList.add(new Score(parts[0].trim(), Integer.parseInt(parts[1].trim())));
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(scoreList);
        return scoreList;
    }
}
