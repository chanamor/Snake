package board;
import javax.swing.*;
import gameobj.Snake;
import java.awt.*;


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
            snakegame = new Snake(border, tile);
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

           
        }

        



           
        }

        



