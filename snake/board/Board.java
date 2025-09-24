package board;

import javax.swing.*;

import gameobj.Snake;

import java.awt.*;


public class Board extends JPanel {


        final int border = 800;
        final int border_height = border;
        final int tile = 25 ;

       
        

        

        public Board() {
            JFrame frame = new JFrame("Snake");
            
            
            frame.setSize(border, border_height);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.add(this);
            setBackground(Color.black);

            Snake snakegame=new Snake(border,border_height );
            frame.add(snakegame);
            frame.pack();
            //Action   
            snakegame.requestFocus();
        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g);
           
        }

        public void draw(Graphics g){
            
            // ทำตาราง grid
            g.setColor(Color.gray);
            for(int i = 0; i < border / tile; i++ ){
                g.drawLine(i*tile, 0, i*tile, border_height);
                g.drawLine(0, i*tile, border, i*tile);
               
                
            }

           

           



           
        }

        
}

