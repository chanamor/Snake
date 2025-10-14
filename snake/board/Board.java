package board;
import javax.swing.*;
import gameobj.Snake;
import java.awt.*;
import java.util.ArrayList;
import score.Score;

public class Board extends JPanel {

    private String playerName;
    private Snake snakegame;
    final int border = 600;
    final int border_height = border;

    public Board(String playerName) {
        this.playerName = playerName;

        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("./image/616653.png");
        frame.setIconImage(icon.getImage());

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(border, border_height));

        snakegame = new Snake(border, 25, this.playerName);
        snakegame.setBounds(0, 0, border, border_height);
        layeredPane.add(snakegame, Integer.valueOf(0));

        this.setOpaque(false);
        this.setBounds(0, 0, border, border_height);
        layeredPane.add(this, Integer.valueOf(1));

        frame.setContentPane(layeredPane);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        snakegame.requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (snakegame != null && snakegame.GameIsOver()) {
            if (!snakegame.isScoresaved()) { 
                snakegame.write_score();
            }
            ReportScore(g);

        } else if (snakegame != null) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Monospaced", Font.BOLD, 18));
            g.drawString("Player: " + playerName, 10, 20);
            g.drawString("Score: " + snakegame.getScore(), 10, 45);
        }
    }

    private void ReportScore(Graphics g) {
    // พื้นหลังและหัวข้อ GAME OVER
    g.setColor(new Color(0, 0, 0, 150));
    g.fillRect(0, 0, border, border_height);

    g.setColor(Color.RED);
    g.setFont(new Font("Monospaced", Font.BOLD, 50));
    FontMetrics metrics1 = g.getFontMetrics();
    g.drawString("GAME OVER", (border - metrics1.stringWidth("GAME OVER")) / 2, 100);

    // แสดงคะแนนของรอบปัจจุบัน
    g.setColor(Color.GREEN);
    g.setFont(new Font("Monospaced", Font.BOLD, 20));
    FontMetrics metricsYourScore = g.getFontMetrics();
    String yourScoreText = "YOUR SCORE: " + playerName + " : " + snakegame.getScore();
    g.drawString(yourScoreText, (border - metricsYourScore.stringWidth(yourScoreText)) / 2, 160);


    // วาดตารางคะแนน
    int y = 220; 
    g.setFont(new Font("Monospaced", Font.PLAIN, 16));
    FontMetrics metrics2 = g.getFontMetrics();

    g.setColor(Color.WHITE);
    g.drawString("--- HIGH SCORES ---", (border - metrics2.stringWidth("--- HIGH SCORES ---")) / 2, y);
    y += 30; // เพิ่มระยะห่าง

    ArrayList<Score> scoreList = Score.getHighScores();
    boolean PlayerInList = false;
    
    // กำหนดว่าลำดับ highscore จะมีกี่ลำดับ
    for (int i = 0; i < Math.min(5, scoreList.size()); i++) {
        Score s = scoreList.get(i);
        String scoreText = s.toString();
        int textX = (border - metrics2.stringWidth(scoreText)) / 2;
        
        if (s.playerName().equals(playerName) && s.score() == snakegame.getScore() && !PlayerInList) {
            g.drawString(scoreText, textX, y);
            g.drawString("       <-- IS YOU ", textX + metrics2.stringWidth(yourScoreText), y);            
            PlayerInList = true;
        }else{
        g.setColor(Color.WHITE); 
        g.drawString(scoreText, textX, y);
            }
        y += 25;
    }

    y += 30;
    g.setFont(new Font("Monospaced", Font.BOLD, 20));
    FontMetrics metrics3 = g.getFontMetrics();
    g.setColor(Color.YELLOW);
    g.drawString("Press Enter to Play Again", (border - metrics3.stringWidth("Press Enter to Play Again")) / 2, y);
    y += 30;
    g.drawString("Press Esc to Exit", (border - metrics3.stringWidth("Press Esc to Exit")) / 2, y);
}
}