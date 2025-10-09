package board;
import javax.swing.*;
import gameobj.Snake;
import java.awt.*;

import score.Score;



public class Board extends JPanel {

        private String playerName;
        private Snake snakegame;


        final int border = 600;
        final int border_height = border;
        final int tile = 25 ;


        public Board(String playerName) {

            this.playerName = playerName;
            


            JFrame frame = new JFrame("Snake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon icon = new ImageIcon("./image/616653.png");
            frame.setIconImage(icon.getImage());

        // ใช้ JLayeredPane
            JLayeredPane layeredPane = new JLayeredPane();
            layeredPane.setPreferredSize(new Dimension(border, border_height));

        // Snake game (เลเยอร์ล่าง)
            snakegame = new Snake(border, tile, this.playerName);
            snakegame.setBounds(0, 0, border, border_height);
            layeredPane.add(snakegame, Integer.valueOf(0));

        // Board (เลเยอร์บน วาด HUD)
            this.setOpaque(false); //  โปร่งใส ไม่ทับ Snake
            this.setBounds(0, 0, border, border_height);
            layeredPane.add(this, Integer.valueOf(1));

            frame.setContentPane(layeredPane);
            frame.pack();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            snakegame.requestFocus();

        }


        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Monospaced", Font.BOLD, 18));
            g.drawString("Player: " + playerName, 10, 20);
            if (snakegame != null) {
                g.drawString("Score: " + snakegame.getScore(), 10, 45);
            }
            
            if(snakegame != null && snakegame.GameIsOver() ){
                ReportScore(g);
            }
        
        }

        private void ReportScore(Graphics g) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, border, border_height);

            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced", Font.BOLD, 50));
            FontMetrics metrics1 = g.getFontMetrics();
            g.drawString("GAME OVER", (border - metrics1.stringWidth("GAME OVER")) / 2, 100);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.PLAIN, 16));
            FontMetrics metrics2 = g.getFontMetrics();
            String highScore = Score.getFormattedHightScore(playerName, snakegame.getScore());

            // วาดข้อความทีละบรรทัด
            int y = 180;
            for (String line : highScore.split("\n")){
                g.drawString(line, (border - metrics2.stringWidth(line)) / 2, y);
                y += 25; // เว้นระยะห่างทีละบรรทัด
            }

            y += 40;
            g.setFont(new Font("Monospaced", Font.BOLD, 20));
            FontMetrics metrics3 = g.getFontMetrics();
            g.setColor(Color.YELLOW);
            g.drawString("Press Enter to Play Egain", (border - metrics3.stringWidth("Press ENTER to Play Again")) / 2, y);
            y += 30; // เว้นบรรทัด
            g.drawString("Press Esc to Exit", (border - metrics3.stringWidth("Press ESC to Exit")) / 2, y);

        }
           
        
    }

        



           
        

        



