package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import gameobj.*;


public class Board extends JPanel implements KeyListener{


        final int border = 600;
        final int border_height = border;
        final int tile = 25 ;

       
        

        

        public Board() {
            JFrame frame = new JFrame();
            frame.setSize(border, border_height);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Snake snakegmae = new Snake(border,border_height);
            frame.add(snakegmae);
            setBackground(Color.black);
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

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
        }

        
}

