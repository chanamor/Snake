package board;

import javax.swing.*;

import gameobj.Snake;

import java.awt.*;


public class Board extends JPanel {


        final int border = 600;
        final int border_height = border;
        final int tile = 25 ;

       
        

        

        public Board() {
            JFrame frame = new JFrame("Snake");
            
        
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon icon = new ImageIcon("./image/616653.png");
            frame.setIconImage(icon.getImage());

            

            Snake snakegame=new Snake(border,border_height );
            frame.add(snakegame);
            frame.pack();
            //Action   
            snakegame.requestFocus();


            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            
           
        }

        



           
        }

        


