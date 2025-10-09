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
    
    public static String getFormattedHightScore(String CurrentNamePlayyer, int CurrentScore) {
        File f = new File("./Score/NAME_SCORE.csv");
        if(!f.exists()) {
            return "--- HIGH SCORE ---\n\n" + new Score(CurrentNamePlayyer, CurrentScore).toString() + " <-- YOU\n";
        }

        ArrayList<Score> scoreList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    try {
                        scoreList.add(new Score(parts[0].trim(), Integer.parseInt(parts[1].trim())));
                    }   catch (NumberFormatException ignored){}
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        Collections.sort(scoreList); // เรียงลำดับ score

        StringBuilder sb = new StringBuilder("--- HIGH SCORES ---\n\n");
        boolean playerfound = false;
        for (int i = 0; i < Math.min(5, scoreList.size());i++){
            Score s = scoreList.get(i);
            sb.append(s.toString());

            if (s.playerName.equals(CurrentNamePlayyer) && s.score() == CurrentScore && !playerfound){
                sb.append(" <-- IS YOU");
                playerfound = true;
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
